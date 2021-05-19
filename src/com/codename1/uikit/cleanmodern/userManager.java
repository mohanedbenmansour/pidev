/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.io.Preferences;

/**
 *
 * @author Lenovo
 */
public class userManager {
    
    public static Preferences pref ; // 3ibara memoire sghira nsajlo fiha data 
    
    
    
    // hethom données ta3 user lyt7b tsajlhom fi session  ba3d login 
    private static int id ; 
    private static String userName ; 
    private static String email; 
    private static String passowrd ;
    private static String photo;
    
    private static String phone_number;
    private static String nom;
    private static String prenom;
    private static String facebookProfil;
    private static String twitch_profil;
    private static String youtube_channel;

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        userManager.pref = pref;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        userManager.id = id;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        userManager.userName = userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        userManager.email = email;
    }

    public static String getPassowrd() {
        return passowrd;
    }

    public static void setPassowrd(String passowrd) {
        userManager.passowrd = passowrd;
    }

    public static String getPhoto() {
        return photo;
    }

    public static void setPhoto(String photo) {
        userManager.photo = photo;
    }

    public static String getPhone_number() {
        return phone_number;
    }

    public static void setPhone_number(String phone_number) {
        userManager.phone_number = phone_number;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        userManager.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setPrenom(String prenom) {
        userManager.prenom = prenom;
    }

    public static String getFacebookProfil() {
        return facebookProfil;
    }

    public static void setFacebookProfil(String facebookProfil) {
        userManager.facebookProfil = facebookProfil;
    }

    public static String getTwitch_profil() {
        return twitch_profil;
    }

    public static void setTwitch_profil(String twitch_profil) {
        userManager.twitch_profil = twitch_profil;
    }

    public static String getYoutube_channel() {
        return youtube_channel;
    }

    public static void setYoutube_channel(String youtube_channel) {
        userManager.youtube_channel = youtube_channel;
    }
    
    
    
}
