package com.walmart.Vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.Vendor.exception.VendorAlreadyExistsException;
import com.walmart.Vendor.exception.VendorNotFoundException;
import com.walmart.Vendor.model.Vendor;
import com.walmart.Vendor.service.VendorService;

@RestController
@RequestMapping("/root/v1")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@PostMapping("/vendor")
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor ven) throws VendorAlreadyExistsException{
		Vendor vend = vendorService.createVendor(ven);
		if (ven == null) {
            return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
        }
		return new ResponseEntity<Vendor>(vend, HttpStatus.CREATED);

	}

	@GetMapping("/vendor")
	public ResponseEntity<List<Vendor>> getAllVendors(){
		return ResponseEntity.ok(vendorService.getAllVendors());
	}
	
	@GetMapping("/getvendor/{vendorEmailId}")
    public ResponseEntity<Vendor> getVendorDetailsByEmail(@PathVariable(value="vendorEmailId") String vendorEmailId) throws VendorNotFoundException {
       Vendor vens=  vendorService.getVendorByEmail(vendorEmailId);
       return new ResponseEntity<Vendor>(vens, HttpStatus.OK);
	}
	
    @PutMapping("/updatevendor/{vendorEmailId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable(value = "vendorEmailId") String vendorEmailId,@RequestBody Vendor venDetails) throws VendorNotFoundException{
        Vendor updateven = vendorService.updateVendor(vendorEmailId,venDetails);
        return new ResponseEntity<Vendor>(updateven, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletevendor/{vendorEmailId}")
    public ResponseEntity<Void> deleteVendor(@PathVariable("vendorEmailId") String vendorEmailId) throws VendorNotFoundException{
    	vendorService.deletVendor(vendorEmailId);
    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        
    }

}
