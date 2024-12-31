package org.example.messerver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * @author 27542
 * 供应商
 */
@Data
@ToString
public class Vendor {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 供应商编码
     */
    private String code;
    /**
     * 供应商简称
     */
    private String nick;
    /**
     * 供应商等级
     */
    private String level;
    /**
     * 是否启用
     * 0：禁用，1：启用
     */
    private String flag;

    /**
     * 供应商评分
     */
    private String score;

    /**
     * 供应商电话
     */
    private String tel;

    private String remark;
}
