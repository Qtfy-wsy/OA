package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Role;
import com.oa.pojo.User;


public interface RoleMapper {
	List<Role> selectRoles(User user);
}
