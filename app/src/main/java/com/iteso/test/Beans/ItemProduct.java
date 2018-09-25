package com.iteso.test.Beans;

public class ItemProduct {

    private int image;
    private String title;
    private String store;
    private String location;
    private String phone;
    private String description;

    public ItemProduct() {
        setImage(0);
        setDescription("");
        setTitle("");
        setPhone("");
        setLocation("");
        setStore("");
    }

    public ItemProduct(int image, String title, String store, String location, String phone, String description) {
        setImage(image);
        setTitle(title);
        setStore(store);
        setLocation(location);
        setPhone(phone);
        setDescription(description);
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", title='" + title + '\n' +
                ", store='" + store + '\n' +
                ", location='" + location + '\n' +
                ", phone='" + phone + '\n' +
                ", description='" + description + '\n' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

