package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Contact {

    private int ID;
    private String fullname;
    private String group;
    private String address;
    private String phone;
    private String firstname;
    private String lastname;


    public Contact() {
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fullname) {
        String[] full = fullname.split(" ");
        this.firstname = full[0];
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String fullname) {
        this.lastname = fullname.substring(fullname.indexOf(" ")).trim();
    }
    

    @Override
    public String toString() {
        return String.format("%-5s%-20s%-20s%-20s%-20s%-20s%-20s", this.getID(),
                this.getFullname(), this.getFirstname(), this.lastname,
                this.group, this.getAddress(), this.getPhone());
    }
}
