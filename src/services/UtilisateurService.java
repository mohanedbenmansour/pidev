/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.charts.views.DialChart;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.ui.Dialog;
import com.codename1.uikit.cleanmodern.SessionManager;
import java.io.IOException;
import java.util.Map;

import utils.Statics;

/**
 *
 * @author seifeddine
 */
public class UtilisateurService {

    public static UtilisateurService instance = null;
    public static String returnTypeSU = "success";
    public static String returnTypeSI = "success";

    public static boolean resultOk = true;
    private ConnectionRequest req;

    public static UtilisateurService getInstance() {
        if (instance == null) {
            instance = new UtilisateurService();
        }
        return instance;
    }

    public UtilisateurService() {
        req = new ConnectionRequest();
    }

    public void SignUp(String username,String password,String Email, String phoneNumber, String nom,String prenom) {
        String url = Statics.BASE_URL + "signUpApi?username=" + username + "&password=" + password + "&email=" + Email + "&phoneNumber=" + phoneNumber + "&nom=" + nom + "&prenom=" + prenom;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            byte[] data = (byte[]) e.getMetaData();
            String responceData = new String(data);
//            if (responceData.equals("\"exist\"")) {
//                returnTypeSU = "exist";
//            } else {
//                returnTypeSI = "success";
//
//            }
            System.out.println("data ======>" + responceData);

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public void SignIn(String username, String password) {
        String url = Statics.BASE_URL + "user/signin?username=" + username + "&password=" + password;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            byte[] data = (byte[]) e.getMetaData();
            String responceData = new String(data);
//            byte[] data = (byte[]) e.getMetaData();
//            String responceData = new String(data);
            System.out.println("json sszsss"+json);
            
    
                    
            if (json.equals("failedp")) {
                returnTypeSI = "faileduser";
                System.out.println("rrrrrrrrrrrrr-"+returnTypeSI);
            } 
            
            else {
                returnTypeSI = "success";
                System.out.println("rrrrrrrrrrrrr-"+returnTypeSI);
                
                
                
                
                    try {
                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    float id = Float.parseFloat(user.get("id").toString());
                SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
                
                SessionManager.setPassowrd(user.get("password").toString());
                SessionManager.setUserName(user.get("username").toString());
                SessionManager.setEmail(user.get("email").toString());
                
                SessionManager.setPhone_number(user.get("phoneNumber").toString());
                SessionManager.setNom(user.get("nom").toString());
                SessionManager.setPrenom(user.get("prenom").toString());
                SessionManager.setFacebookProfil(user.get("facebookprofil").toString());
                SessionManager.setTwitch_profil(user.get("twitchProfil").toString());
                SessionManager.setYoutube_channel(user.get("youtubeChannel").toString());
                
                //photo 
                
                if(user.get("photo") != null)
                    SessionManager.setPhoto(user.get("photo").toString());
                
                        System.out.println("current user ==>"+SessionManager.getUserName()+ ","+SessionManager.getPassowrd()+","+SessionManager.getPassowrd());
                      

                } catch (IOException ex) {
                    System.out.println(ex);
                }
                       


                } 

            
                
                
            

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    
    public void search(String username) {
        String url = Statics.BASE_URL + "user/search?username=" + username;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            byte[] data = (byte[]) e.getMetaData();
            String responceData = new String(data);
//            byte[] data = (byte[]) e.getMetaData();
//            String responceData = new String(data);
            System.out.println("json sszsss"+json);
            
    
                    
            if (json.equals("failedu")) {
                returnTypeSI = "faileduser";
                System.out.println("rrrrrrrrrrrrr-"+returnTypeSI);
            } 
            
            else {
                returnTypeSI = "success";
                System.out.println("rrrrrrrrrrrrr-"+returnTypeSI);
                
                
                
                
                    try {
                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    float id = Float.parseFloat(user.get("id").toString());
                SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
                
                SessionManager.setPassowrd(user.get("password").toString());
                SessionManager.setUserName(user.get("username").toString());
                SessionManager.setEmail(user.get("email").toString());
                
                SessionManager.setPhone_number(user.get("phoneNumber").toString());
                SessionManager.setNom(user.get("nom").toString());
                SessionManager.setPrenom(user.get("prenom").toString());
                SessionManager.setFacebookProfil(user.get("facebookprofil").toString());
                SessionManager.setTwitch_profil(user.get("twitchProfil").toString());
                SessionManager.setYoutube_channel(user.get("youtubeChannel").toString());
                
                //photo 
                
                if(user.get("photo") != null)
                    SessionManager.setPhoto(user.get("photo").toString());
                
                        System.out.println("current user ==>"+SessionManager.getUserName()+ ","+SessionManager.getPassowrd()+","+SessionManager.getPassowrd());
                      

                } catch (IOException ex) {
                    System.out.println(ex);
                }
                       


                } 

            
                
                
            

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    

}
