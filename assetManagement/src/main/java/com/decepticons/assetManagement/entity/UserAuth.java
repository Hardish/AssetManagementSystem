package com.decepticons.assetManagement.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
//@RequiredArgsConstructor(staticName = "of")
//@AllArgsConstructor
@Document(collection = "Authorization")
public class UserAuth {

	@Getter
	@Setter
	
	@Id
	public String id;
	
	@Field("user_name")
	public String userName;
	
	public String password;

}
