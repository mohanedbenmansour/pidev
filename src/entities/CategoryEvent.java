/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus
 */
public class CategoryEvent {
    
    private int id;
    private String name;

    public CategoryEvent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryEvent(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
