// package com.example.item.domain.entity;
//
// import com.baomidou.mybatisplus.annotation.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
//
// import java.util.Date;
//
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class DispatchOrder {
//
//     // 对应数据库中的组件（uuid、自增ID、雪花算法、redis、zookeeper）
//     @TableId(type = IdType.AUTO) // 当前设置为自增ID
//     private Integer id;
//
//     private String code;
//
//     private Integer status;
//
//     @TableField(fill = FieldFill.INSERT)
//     private Date createTime;
//
//     @TableField(fill = FieldFill.INSERT_UPDATE)
//     private Date updateTime;
//
//     @Version
//     private Integer version;
//
//     @TableLogic
//     private Integer deleted;
//
// }
