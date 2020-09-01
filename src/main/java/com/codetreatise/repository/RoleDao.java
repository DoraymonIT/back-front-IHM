package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
