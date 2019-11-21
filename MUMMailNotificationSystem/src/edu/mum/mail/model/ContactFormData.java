package edu.mum.mail.model;

public class ContactFormData {
    private int contactsId;
    private String name;
    private String gender;
    private String category;
    private String message;

    public ContactFormData() {
    }

    public ContactFormData(String name, String gender, String category, String message) {
        this.name = name;
        this.gender = gender;
        this.category = category;
        this.message = message;
    }

    public ContactFormData(int contactsId, String name, String gender, String category, String message) {
        this.contactsId = contactsId;
        this.name = name;
        this.gender = gender;
        this.category = category;
        this.message = message;
    }

    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactFormData{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
