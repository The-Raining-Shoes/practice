package com.example.item.entity.entityInfo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "goods_info")
public class GoodsInfo implements Serializable{

	private static final long serialVersionUID = 5291797611898175601L;

	/**
	 * 物品ID
	 */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  	@Column(name = "GOODS_ID" )
	private BigInteger goodsId;
	
	/**
	 * 物品类别
	 */
  	@Column(name = "GOODS_TYPE" )
	private int goodsType;
  	
  	/**
	 * 物品名称
	 */
  	@Column(name = "GOODS_NAME" )
	private String goodsName;
  	
  	/**
	 * 寄存用户ID
	 */
  	@Column(name = "USER_ID" )
	private int userId;
  	
  	/**
	 * 创建时间
	 */
  	@Column(name = "CREATE_DATE" )
	private Date createDate;
  	
  	/**
	 * 存放年限
	 */
  	@Column(name = "GOODS_TIME" )
	private Date goodsTime;
  	
  	/**
	 * 所需费用
	 */
  	@Column(name = "GOODS_COST" )
	private BigDecimal goodsCost;
  	
  	/**
	 * 是非保密
	 */
  	@Column(name = "GOODS_IS_SHOW" )
	private String goodsIsShow;
  	
  	/**
	 * 物品故事
	 */
  	@Column(name = "GOODS_STORY" )
	private String goodsStory;
}
