package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
