


import java.io.*;
import java.util.*;

class Student extends User implements Serializable {
    private String rollNumber;
    private String contactNumber;
    private Bus relatedBus;

    public Student(String name, String email, String password, String rollNumber, String contactNumber){
        super(name, email, password);
        this.rollNumber = rollNumber;
        this.contactNumber = contactNumber;
    }

    public String getRollNumber(){
        return rollNumber;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public Bus getRelatedBus(){
        return relatedBus;
    }

    public void setRollNumber(String rollNumber){
        this.rollNumber = rollNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    public void setRelatedBus(Bus relatedBus){
        this.relatedBus = relatedBus;
    }
}
