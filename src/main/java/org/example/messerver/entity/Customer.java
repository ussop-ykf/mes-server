package org.example.messerver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * @author 27542
 * 客户
 */
@Data
@ToString
public class Customer {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 客户编码
     */
    private String code;
    /**
     * 客户简称
     */
    private String nick;
    /**
     * 客户类型
     */
    private String type;
    /**
     * 客户电话
     */
    private String tel;
    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人电话
     */
    private String contactTel;
}
