package com.walmart.Vendor.service;

import java.util.List;

import com.walmart.Vendor.exception.VendorAlreadyExistsException;
import com.walmart.Vendor.exception.VendorNotFoundException;
import com.walmart.Vendor.model.Vendor;

public interface VendorService {
	
	public Vendor createVendor(Vendor ven) throws VendorAlreadyExistsException;

	public List<Vendor> getAllVendors();

	public Vendor getVendorByEmail(String vendorEmailId) throws VendorNotFoundException;

	public Vendor updateVendor(String vendorEmailId, Vendor venDetails) throws VendorNotFoundException;

	public void deletVendor(String vendorEmailId) throws VendorNotFoundException;

}
