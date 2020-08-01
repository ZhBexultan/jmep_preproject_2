package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);
    List<Role> getAllRoles();

}
