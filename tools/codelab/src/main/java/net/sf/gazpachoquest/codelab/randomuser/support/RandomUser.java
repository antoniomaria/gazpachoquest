/*
 * This code has been copied from:
 * https://github.com/aliilyas/RandomUserApiClient
 */
package net.sf.gazpachoquest.codelab.randomuser.support;

/**
 * 
 * @author Ilyas
 */
public class RandomUser {

    private NameEntry name;
    private LocationEntry location;
    private String gender;
    private String email;
    private String username;
    private String password;
    private String salt;
    private String cell;
    private String picture;
    private String md5;
    private String sha1;
    private String sha256;
    private String registered;
    private String dob;
    private String phone;
    private String SSN;

    public RandomUser() {
    }

    public NameEntry getName() {
        return name;
    }

    public void setName(NameEntry name) {
        this.name = name;
    }

    public LocationEntry getLocation() {
        return location;
    }

    public void setLocation(LocationEntry location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "RandomUser [name=" + name + ", location=" + location + ", gender=" + gender + ", email=" + email
                + ", username=" + username + ", password=" + password + ", cell=" + cell + ", picture=" + picture
                + ", registered=" + registered + ", dob=" + dob + ", phone=" + phone + ", SSN=" + SSN + "]";
    }

}
