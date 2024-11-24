package com.springbootacademy.batch8.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity                                     //need to create database first
@Table(name = "customer")                                      //database ake name
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)        //If we need to use JSon in this class can use this dependency.It is in pom.xml file.
})
public class Customer {

    @Id                                     //Primary key--OOP endcapsulation consept
    @Column(name = "customer_id", length = 45)      // database ake column eka tiynne one nama
    @GeneratedValue(strategy = GenerationType.AUTO)   //we use this for ids auto generates
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)     //null wenna ba nama
    private String customerName;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(type = "json")                                                //we use arraylist to enter more contact numbers
    @Column(name = "contact_numbers", length = 10, columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean active;

    public Customer(){
                                            //No args no return type constructor.It has not any arguments.
    }

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList contactNumber, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
