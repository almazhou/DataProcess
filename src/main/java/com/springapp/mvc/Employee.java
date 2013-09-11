package com.springapp.mvc;

import java.util.Date;

public class Employee {

    private Long id;

    private String firstname;

    private String lastname;

    private Date birthDate;

    private String cellphone;

    public Employee() {

    }

    public Employee(long id, String firstname, String lastname, Date birthdate, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthdate;
        this.cellphone = phone;

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }
}
