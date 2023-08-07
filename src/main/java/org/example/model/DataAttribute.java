package org.example.model;

public class DataAttribute {
    private String FirstName;
    private String LastName;
    private Integer Age;
    private String Email;

    public DataAttribute(String firstName, String lastName, Integer age, String email) {
        FirstName = firstName == null ? "" : firstName;
        LastName = lastName == null ? "" : lastName;
        Age = age == null ? 0 : age;
        Email = email == null ? ""  : email;
    }

    public DataAttribute() {
        FirstName = "";
        LastName = "";
        Age = 0;
        Email = "";
    }

    public DataAttribute Create (String[] attribute) {
        return new DataAttribute(attribute[0], attribute[1], Integer.parseInt(attribute[2]), attribute[3]);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "DataAttribute{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                ", Email='" + Email + '\'' +
                '}';
    }
}
