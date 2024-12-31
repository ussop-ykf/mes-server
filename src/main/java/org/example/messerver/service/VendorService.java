package org.example.messerver.service;

import org.example.messerver.entity.Vendor;

import java.util.List;

/**
 * @author 27542
 */
public interface VendorService {
    List<Vendor> queryVendorList(Vendor vendor);
    Boolean addVendor(Vendor vendor);
    Boolean updateVendor(Vendor vendor);
    Boolean deleteVendor(Integer id);
}
