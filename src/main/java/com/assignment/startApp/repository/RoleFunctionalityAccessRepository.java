package com.assignment.startApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.startApp.entity.RoleFunctionalityAccess;

@Repository
public interface RoleFunctionalityAccessRepository extends JpaRepository<RoleFunctionalityAccess, Integer> {

    List<RoleFunctionalityAccess> findByRoleId(Integer roleId);
}
