/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;


/**
 *
 * @author asus
 */
public class Event {
    
    private int id;
    private String name, description ,lieu,img,etat;
    private int nbP;
    private Date dateDeb,dateFin,datePub;
    private float prix;
    private int category,user;

    public Event(int id, String name, String description, String lieu, String img, String etat, int nbP, Date dateDeb, Date dateFin, Date datePub, float prix, int category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lieu = lieu;
        this.img = img;
        this.etat = etat;
        this.nbP = nbP;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.datePub = datePub;
        this.prix = prix;
        this.category = category;
    }

    public Event(String name, String description, String lieu, String img,  int nbP, Date dateDeb, Date dateFin, float prix, int category) {
        this.name = name;
        this.description = description;
        this.lieu = lieu;
        this.img = img;
        this.nbP = nbP;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.prix = prix;
        this.category = category;
    }
    
    public Event(String name, String description, String lieu, String img,  int nbP, Date dateDeb, Date dateFin, float prix) {
        this.name = name;
        this.description = description;
        this.lieu = lieu;
        this.img = img;
        this.nbP = nbP;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public Event(int id, String name, String description, String lieu, String img, int nbP, Date dateDeb, Date dateFin, Date datePub, float prix, int cat, int user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lieu = lieu;
        this.img = img;
        this.nbP = nbP;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.datePub = datePub;
        this.prix = prix;
        this.category = cat;
        this.user=user;

    }
    
    public Event(int id, String name, String description, String lieu, String img, int nbP, Date dateDeb, Date dateFin, float prix) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lieu = lieu;
        this.img = img;
        this.nbP = nbP;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.prix = prix;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getNbP() {
        return nbP;
    }

    public void setNbP(int nbP) {
        this.nbP = nbP;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

  

    
}
