package com.example.item.entity.entityInfo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description  
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 5291797611898175601L;
	
	/**
	 * 用户ID
	 */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  	@Column(name = "USER_ID" )
	private BigInteger userId;
	
	/**
	 * 用户名称
	 */
  	@Column(name = "USER_NAME" )
	private String userName;
  	
  	/**
	 * 用户密码
	 */
  	@Column(name = "USER_PASSWORD" )
	private String userPassword;

  	/**
	 * 用户年龄
	 */
  	@Column(name = "USER_AGE" )
  	private int userAge;
  	
  	/**
	 * 用户联系电话
	 */
  	@Column(name = "USER_TEL" )
  	private String userTel;
  
	/**
	 * 用户性别(1男，2女)
	 */
  	@Column(name = "USER_SEX" )
  	private int userSex;
  	
  	/**
	 * 用户注册时间
	 */
  	@Column(name = "CREATE_DATE" )
  	private Date createDate;
}
