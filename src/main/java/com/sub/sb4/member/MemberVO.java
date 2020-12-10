package com.sub.sb4.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	@Length(min =4, max =8)
	private String pw;
	
	@Size(min = 2)
	private String name;
	
	@Range(min = 1, max = 200)
	public int age;
	
	@Email
	private String email;
	
	private List<MemberRoleVO> roles;

}
