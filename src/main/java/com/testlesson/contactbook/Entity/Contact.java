package com.testlesson.contactbook.Entity;

public class Contact {
    private Long id;
    private String Name;
    private Long phoneNumber;

    public Contact(Long id, String name, Long phoneNumber) {
        this.id = id;
        Name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
