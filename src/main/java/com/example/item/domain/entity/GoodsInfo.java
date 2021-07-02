package com.example.item.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * null
 * @author Auto Generate 2019-12-20 16:25:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name ="goods_info")
public class GoodsInfo implements Serializable {

	/**
	 * 寄存物品ID
	 */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  	@Column(name = "GOODS_ID")
	private BigInteger goodsId;

	/**
	 * 寄存物品类别
	 */
  	@Column(name = "GOODS_TYPE")
	private Integer goodsType;

	/**
	 * 寄存物品名称
	 */
  	@Column(name = "GOODS_NAME")
	private String goodsName;

	/**
	 * 寄存用户ID
	 */
  	@Column(name = "USER_ID")
	private Integer userId;

	/**
	 * 存放日期
	 */
  	@Column(name = "CREATE_DATE")
	private Date createDate;

	/**
	 * 存放年限
	 */
  	@Column(name = "GOODS_TIME")
	private Date goodsTime;

	/**
	 * 所需费用
	 */
  	@Column(name = "GOODS_COST")
	private BigDecimal goodsCost;

	/**
	 * 是否保密
	 */
  	@Column(name = "GOODS_IS_SHOW")
	private String goodsIsShow;

	/**
	 * 物品故事
	 */
  	@Column(name = "GOODS_STORY")
	private String goodsStory;

	/**
	 * 物品链接
	 */
  	@Column(name = "GOODS_SRC")
	private String goodsSrc;

	/**
	 * 物品价格
	 */
  	@Column(name = "GOODS_PRICE")
	private String goodsPrice;

	public void setCreateStaff(Integer staff){}

	public void setUpdateStaff(Integer staff){}

	public void setUpdateDate(Date date){}

	public void setHisSerial(String serial){}

	private static final long serialVersionUID =  5258146630554391489L;

}
