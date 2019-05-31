package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Data
@Entity
@Table(name = "Roles")
public class Role {

	@Getter
	@Setter
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_RoleSequence")
	@SequenceGenerator(name = "id_RoleSequence", sequenceName = "ROLES_ID_SEQ", allocationSize = 1)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;


}