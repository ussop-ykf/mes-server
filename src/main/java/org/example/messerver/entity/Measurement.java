package org.example.messerver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * @author 27542
 * 计量单位
 */
@Data
@ToString
public class Measurement {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 与主单位换算比例
     */
    private String rate;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否启用
     * 0：禁用，1：启用
     */
    private String flag;
}
