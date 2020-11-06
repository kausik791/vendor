package com.walmart.Vendor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.walmart.Vendor.exception.VendorAlreadyExistsException;
import com.walmart.Vendor.exception.VendorNotFoundException;
import com.walmart.Vendor.model.Vendor;
import com.walmart.Vendor.repository.VendorRespository;
import com.walmart.Vendor.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRespository vendorRespository;
	
    @Value("${app.exception.vendorAlreadyExists}")
    private String exceptionMsgForVendorAlreadyExists;

    @Value("${app.exception.vendorNotFound}")
    private String exceptionMsgForVendorNotFound;

	@Override
	public Vendor createVendor(Vendor ven) throws VendorAlreadyExistsException{
		if(vendorRespository.findById(ven.getVendorEmailId()).isPresent())
        {
            throw new VendorAlreadyExistsException(exceptionMsgForVendorAlreadyExists);
        }
		return vendorRespository.save(ven);
		
	}

	@Override
	public List<Vendor> getAllVendors() {
		return (List<Vendor>)vendorRespository.findAll();

	}

	@Override
	public Vendor getVendorByEmail(String vendorEmailId) throws VendorNotFoundException {
		
		if(vendorRespository.findById(vendorEmailId).isPresent()) {
			return vendorRespository.findById(vendorEmailId).get();
		}
	
		 throw new VendorNotFoundException(exceptionMsgForVendorNotFound);
	}

	@Override
	public Vendor updateVendor(String vendorEmailId, Vendor venDetails) throws VendorNotFoundException {
		
		if(vendorRespository.findById(vendorEmailId).isPresent()) {
			Vendor vendor = vendorRespository.findById(vendorEmailId).get();
			vendor.setVendorName(venDetails.getVendorName());
			vendor.setVendorAddress(venDetails.getVendorAddress());
			vendor.setVendorPhoneNumber(venDetails.getVendorPhoneNumber());
			return vendorRespository.save(vendor);
		}
		
		 throw new VendorNotFoundException(exceptionMsgForVendorNotFound);
	}

	@Override
	public void deletVendor(String vendorEmailId) throws VendorNotFoundException {
		if(vendorRespository.findById(vendorEmailId).isPresent()) {
			vendorRespository.deleteById(vendorEmailId);			
		}
		throw new VendorNotFoundException(exceptionMsgForVendorNotFound);
	}

}
