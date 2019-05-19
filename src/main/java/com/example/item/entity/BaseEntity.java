package com.example.item.entity;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 * @author HXM
 *
 */
@Data
public abstract class BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 7445047267071289075L;

    public abstract void setCreateStaff(BigInteger createStaff);

    public abstract void setUpdateStaff(BigInteger createStaff);

    public abstract void setCreateDate(Date date);

    public abstract void setUpdateDate(Date date);

    /**
     * 
     * @param operType
     */
    public void setOperSave(int operType) {
        switch (operType) {
            case 1:// 设置create
                setCreateDate(new Date());
            case 2:// 设置update
                setUpdateDate(new Date());
            default:
                break;
        }
    }

}