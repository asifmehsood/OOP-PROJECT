

import java.io.*;
import java.util.*;

class Driver extends User implements Serializable {
    private String licenseNumber;
    private String contactNumber;
    private Bus relatedBus;

    public Driver(String name, String email, String password, String licenseNumber, String contactNumber){
        super(name, email, password);
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public Bus getRelatedBus(){
        return relatedBus;
    }

    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    public void setRelatedBus(Bus relatedBus){
        this.relatedBus = relatedBus;
    }
}