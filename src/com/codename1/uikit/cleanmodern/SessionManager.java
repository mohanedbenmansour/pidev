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
public class SessionManager {
    
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

    public static String getPhone_number() {
        return phone_number;
    }

    public static void setPhone_number(String phone_number) {
        SessionManager.phone_number = phone_number;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        SessionManager.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setPrenom(String prenom) {
        SessionManager.prenom = prenom;
    }

    public static String getFacebookProfil() {
        return facebookProfil;
    }

    public static void setFacebookProfil(String facebookProfil) {
        SessionManager.facebookProfil = facebookProfil;
    }

    public static String getTwitch_profil() {
        return twitch_profil;
    }

    public static void setTwitch_profil(String twitch_profil) {
        SessionManager.twitch_profil = twitch_profil;
    }

    public static String getYoutube_channel() {
        return youtube_channel;
    }

    public static void setYoutube_channel(String youtube_channel) {
        SessionManager.youtube_channel = youtube_channel;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id",id);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setId(int id) {
        pref.set("id",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getUserName() {
        return pref.get("username",userName);
    }

    public static void setUserName(String userName) {
         pref.set("username",userName);
    }

    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }

    public static String getPassowrd() {
        return pref.get("passowrd",passowrd);
    }

    public static void setPassowrd(String passowrd) {
         pref.set("passowrd",passowrd);
    }

    public static String getPhoto() {
        return pref.get("photo",photo);
    }

    public static void setPhoto(String photo) {
         pref.set("photo",photo);
    }
    
}
