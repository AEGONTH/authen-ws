package com.adms.auth.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adms.auth.entity.Role;
import com.adms.auth.entity.RolePrivilege;
import com.adms.auth.entity.User;
import com.adms.auth.entity.UserRole;
import com.adms.auth.service.RolePrivilegeService;
import com.adms.auth.service.UserRoleService;
import com.adms.auth.service.UserService;
import com.adms.common.entity.UserLogin;
import com.google.gson.Gson;

@Component
@Path("/authservice")
public class AuthWS {
	
	private final String USER_ACTION = "Auth Service";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RolePrivilegeService rolePrivilegeService;
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService() {
		String result = "RESTService Successfully started...: ";
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public String auth(@HeaderParam("val") String gsonObject) {
		Gson gson = new Gson();
		UserLogin userLogin = null;
		
		try {
			userLogin = gson.fromJson(gsonObject, UserLogin.class);
			User user = getUser(userLogin.getUsername());
			
			if(user == null) {
				//User not found
				userLogin.loginSuccess(Boolean.FALSE);
			} else {
				//User found
				Date currDate = new Date();
				user.setLastLogin(currDate);
				if(user.getPwd().equals(userLogin.getPwd())) {
					//Success Map User & Password
					user.setFailAttemp(0);
					userLogin.loginDate(currDate).loginSuccess(Boolean.TRUE);
					
					//Retrieving role & privilege
					List<UserRole> userRoles = getUserRoleByUserId(user.getId());
					if(!userRoles.isEmpty()) {
						Map<String, List<String>> rolePrivileges = new HashMap<>();
						List<String> privileges = null;
						
						//Filter only active role
						userRoles = userRoles.stream().filter(ur -> ur.getActive().equals("Y")).collect(Collectors.toList());
						
						for(UserRole userRole : userRoles) {
							Role role = userRole.getRole();
							privileges = new ArrayList<>();
							rolePrivileges.put(role.getRoleCode(), privileges);
							
							List<RolePrivilege> rpList = getRolePrivByRoleId(role.getId());
							for(RolePrivilege rp : rpList) {
								privileges.add(rp.getPrivilege().getPrivilegeCode());
							}
						}
						userLogin.rolePrivileges(rolePrivileges);
					}
				} else {
					//wrong password
					user.setFailAttemp(user.getFailAttemp() + 1);
					userLogin.loginSuccess(Boolean.FALSE);
				}
				userService.update(user, USER_ACTION);
			}
			
			//Clear password in object before send Object back
			return gson.toJson(userLogin.pwd(null));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@GET
	@Path("/chgpwd")
	@Produces(MediaType.APPLICATION_JSON)
	public String changePwd(@HeaderParam("val") String gsonObject) {
		Gson gson = new Gson();
		UserLogin userLogin = null;
		
		try {
			userLogin = gson.fromJson(gsonObject, UserLogin.class);
			User user = getUser(userLogin.getUsername());
			
			if(user == null) {
				userLogin.loginSuccess(Boolean.FALSE);
			} else {
				Date currDate = new Date();
				user.setLastLogin(currDate);
				
				if(user.getPwd().equals(userLogin.getPwd())) {
					//OK, changing password
					user.setLastPwd(user.getPwd())
						.setPwd(userLogin.getNewPwd())
						.setLastLogin(new Date());
					userLogin.loginSuccess(Boolean.TRUE);
				} else {
					//wrong password
					user.setFailAttemp(user.getFailAttemp() + 1);
					userLogin.loginSuccess(Boolean.FALSE);
				}
				userService.update(user, USER_ACTION);
			}

			//Clear password in object before send Object back
			return gson.toJson(userLogin.pwd(null).setNewPwd(null));
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		return gson.toJson(null);
	}
	
	private User getUser(String username) {
		User user = null;
		
		try {
			List<User> list = userService.find(new User(username).setActive("Y"));
			if(!list.isEmpty()) {
				user = list.get(0);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	private List<UserRole> getUserRoleByUserId(Long userId) {
		List<UserRole> userRoles = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserRole.class);
			criteria.add(Restrictions.eq("user.id", userId));
			criteria.add(Restrictions.eq("active", "Y"));
			criteria.addOrder(Order.asc("role.id"));
			userRoles = userRoleService.findByCriteria(criteria);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userRoles;
	}
	
	private List<RolePrivilege> getRolePrivByRoleId(Long roleId) {
		List<RolePrivilege> list = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RolePrivilege.class);
			criteria.add(Restrictions.eq("role.id", roleId)).addOrder(Order.asc("role.id"));
			list = rolePrivilegeService.findByCriteria(criteria);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
