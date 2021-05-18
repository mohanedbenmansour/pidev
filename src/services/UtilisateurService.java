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

    

}
