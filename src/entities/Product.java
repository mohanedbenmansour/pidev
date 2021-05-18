/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mohan
 */
public class Product {
   private int id;
    private String name, description ,price,image;
    private CategoryProduct category;

   
public CategoryProduct getCategory() {
        return category;
    }

    public Product(String name, String description, String price, String image, CategoryProduct category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
     public void setCategory(CategoryProduct category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image=" + image + '}';
    }
    
}
