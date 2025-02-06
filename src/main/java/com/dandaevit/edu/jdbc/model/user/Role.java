package com.dandaevit.edu.jdbc.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
	private final Integer id;
	private final String roleName;
	private final String roleCode;

	public Role(Integer id, String roleName, String roleCode) {
		this.id = id;
		this.roleName = roleName;
		this.roleCode = roleCode;
	}

	public Integer getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

}
