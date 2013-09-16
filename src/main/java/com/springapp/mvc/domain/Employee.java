package com.springapp.mvc.domain;

import java.util.Date;

public class Employee {

    private Long id;

    private String account;

    private String name;

    private double rate;

    private Date timeToJoin;

    private double totalWorkYear;

    private double timeInTW;

    private boolean graduate;

    private boolean onceOut;

    private double timeOnThisAccount;

    public Employee() {

    }

    public Employee(long id,String account,String name,double rate,double timeInTW,Date timeToJoin,double timeOnThisAccount,double totalWorkYear,boolean isGraduate,boolean onceOut) {
        this.id = id;
        this.account = account;
        this.graduate =isGraduate;
        this.name = name;
        this.onceOut = onceOut;
        this.rate = rate;
        this.timeInTW = timeInTW;
        this.timeOnThisAccount = timeOnThisAccount;
        this.timeToJoin = timeToJoin;
        this.totalWorkYear = totalWorkYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getTimeToJoin() {

        return timeToJoin;
    }

    public void setTimeToJoin(Date timeToJoin) {
        this.timeToJoin = timeToJoin;
    }

    public double getTotalWorkYear() {
        return totalWorkYear;
    }

    public void setTotalWorkYear(double totalWorkYear) {
        this.totalWorkYear = totalWorkYear;
    }

    public double getTimeInTW() {
        return timeInTW;
    }

    public void setTimeInTW(double timeInTW) {
        this.timeInTW = timeInTW;
    }

    public boolean getGraduate() {
        return graduate;
    }

    public boolean isOnceOut() {
        return onceOut;
    }

    public void setOnceOut(boolean onceOut) {
        this.onceOut = onceOut;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
    }


    public double getTimeOnThisAccount() {
        return timeOnThisAccount;
    }

    public void setTimeOnThisAccount(double timeOnThisAccount) {
        this.timeOnThisAccount = timeOnThisAccount;
    }

    public int getColumnCount() {
       return getClass().getDeclaredFields().length;
    }
}
