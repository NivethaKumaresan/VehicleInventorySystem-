package com.fb;

import jakarta.persistence.*;

//import java.sql.Date;
import java.time.LocalDate;
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "users") // Table name in MySQL
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

     //@Temporal(TemporalType.DATE)
    @Column(name = "dob", nullable = false)
    private LocalDate dob; // Date of birth

    @Column(name = "gender", nullable = false)
    private String gender; // Male, Female, Custom

    @Column(name = "mobile_number", unique = true, nullable = false)
    private String mobileNumber;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    // Default constructor (required by JPA)
    public UserInfo() {
        this.registeredAt = LocalDateTime.now(); // Set registration time
    }

    // Parameterized constructor
    public UserInfo(String firstName, String lastName, String userName, String password, 
                    LocalDate dob, String gender, String mobileNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.registeredAt = LocalDateTime.now();
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    // ToString method
    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
               ", userName=" + userName + ", password=" + password + ", dob=" + dob +
               ", gender=" + gender + ", mobileNumber=" + mobileNumber +
               ", address=" + address + ", registeredAt=" + registeredAt + "]";
    }
}
