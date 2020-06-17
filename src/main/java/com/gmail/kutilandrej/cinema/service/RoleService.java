package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
