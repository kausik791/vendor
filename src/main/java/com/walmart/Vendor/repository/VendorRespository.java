package com.walmart.Vendor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.walmart.Vendor.model.Vendor;

@Repository
public interface VendorRespository extends JpaRepository<Vendor, String>{

}
