package com.assignment.startApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role_functionality_access")
@Getter
@Setter
public class RoleFunctionalityAccess {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getRoleId() {
	return roleId;
}

public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}

public Integer getFunctionalityId() {
	return functionalityId;
}

public void setFunctionalityId(Integer functionalityId) {
	this.functionalityId = functionalityId;
}

public String getAccessType() {
	return accessType;
}

public void setAccessType(String accessType) {
	this.accessType = accessType;
}

	@Column(name = "role_id")
    private Integer roleId;

    @Column(name = "functionality_id")
    private Integer functionalityId;

    @Column(name = "access_type")
    private String accessType;
    // 'read_only', 'edit', 'no_access'
}

