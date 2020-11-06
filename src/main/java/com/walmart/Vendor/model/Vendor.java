package com.walmart.Vendor.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name ="vendor")
public class Vendor{
	
    @Id
    private String vendorEmailId;
    private String vendorName;
    private long VendorPhoneNumber;
    private String VendorAddress;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorEmailId() {
        return vendorEmailId;
    }

    public void setVendorEmailId(String vendorEmailId) {
        this.vendorEmailId = vendorEmailId;
    }

    public long getVendorPhoneNumber() {
        return VendorPhoneNumber;
    }

    public void setVendorPhoneNumber(long vendorPhoneNumber) {
        VendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }
    
    public Vendor() {
    }
    
    public Vendor(String vendorName, String vendorEmailId, long vendorPhoneNumber, String vendorAddress) {
        this.vendorName = vendorName;
        this.vendorEmailId = vendorEmailId;
        VendorPhoneNumber = vendorPhoneNumber;
        VendorAddress = vendorAddress;
    }


}
