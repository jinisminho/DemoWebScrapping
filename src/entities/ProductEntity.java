/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Hoang Pham
 */
public class ProductEntity {

    private int id;
    private String name;
    private double price;
    private String description;
    private String signature;
    private int typeId;
    private int categoryId;

    public ProductEntity() {
        this.name = "demo";
        this.price = 0;
        this.description = "demo";
        this.signature = "demo";
        this.typeId = -1;
        this.categoryId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", signature=" + signature + ", typeId=" + typeId + ", categoryId=" + categoryId + "\n";
    }

 

}
