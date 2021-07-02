package com.example.item.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * null
 *
 * @author Auto Generate 2019-12-20 16:25:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "t_order_detail")
public class TOrderDetail implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    private static final long serialVersionUID = 5258146630554391489L;

}
