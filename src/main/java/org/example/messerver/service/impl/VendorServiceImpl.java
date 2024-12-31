package org.example.messerver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.messerver.entity.Vendor;
import org.example.messerver.entity.Vendor;
import org.example.messerver.mapper.VendorMapper;
import org.example.messerver.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 27542
 */
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorMapper vendorMapper;
    /**
     * @param vendor
     * @return
     */
    @Override
    public List<Vendor> queryVendorList(Vendor vendor) {
        QueryWrapper<Vendor> wrapper = new QueryWrapper<>();
        // 检查属性是否为 null，避免传递 null 值给 Map.of()
        Map<String, String> fieldMap = Map.of(
                "Id", Objects.toString(vendor.getId(), ""),
                "Code", Objects.toString(vendor.getCode(), ""),
                "Name", Objects.toString(vendor.getName(), ""),
                "Nick", Objects.toString(vendor.getNick(), ""),
                "Tel", Objects.toString(vendor.getTel(), ""),
                "Level", Objects.toString(vendor.getLevel(), ""),
                "Score", Objects.toString(vendor.getScore(), ""),
                "Remark", Objects.toString(vendor.getRemark(), "")
        );

        // 使用循环来遍历字段和对应值进行条件判断
        fieldMap.forEach((field, value) -> {
            if (!value.isEmpty()) {  // 仅当值不为空时添加查询条件
                System.out.print(value);
                wrapper.like(field, value);
            }
        });

        return vendorMapper.selectList(wrapper);
    }

    /**
     * @param vendor
     * @return
     */
    @Override
    public Boolean addVendor(Vendor vendor) {
        return vendorMapper.insert(vendor) > 0;
    }

    /**
     * @param vendor
     * @return
     */
    @Override
    public Boolean updateVendor(Vendor vendor) {
        return vendorMapper.updateById(vendor) > 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Boolean deleteVendor(Integer id) {
        return vendorMapper.deleteById(id) > 0;
    }
}
