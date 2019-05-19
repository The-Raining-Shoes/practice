package com.example.item.entity.entityInfo;

import java.io.Serializable;
import java.math.BigInteger;

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

}
