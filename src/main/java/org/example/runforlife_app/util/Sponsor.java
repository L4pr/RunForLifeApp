package org.example.runforlife_app.util;

public class Sponsor {

    private String company;
    private String name;
    private String phoneNumber;
    private String email;
    private double donated;
    private String remarks;
    private boolean payed;

    public Sponsor() {}

    public Sponsor(String company, String name, double donated, String phoneNumber, String email, String remarks) {
        this.company = company;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donated = donated;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", donated=" + donated +
                ", payed=" + payed +
                '}';
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDonated() {
        return donated;
    }

    public void setDonated(double donated) {
        this.donated = donated;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
