/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import entities.Gamers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;








import java.util.List;

import java.util.Map;
import utils.Statics;


import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class GamerService {
    public ArrayList<Gamers> gamers;
            public static GamerService instance;
            public boolean resultOK;
            private ConnectionRequest req;

    public GamerService() {
        req=new ConnectionRequest();
    }
    
    public static GamerService getInstance(){
        if (instance == null) {
            instance = new GamerService();
        }
        return instance;
    }
    
    public boolean addGamer(Gamers g){
        String url = Statics.BASE_URL + "/api/gamers"+ g.getName() + "/" + g.getDescription();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt){
                resultOK=req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public ArrayList<Gamers> parseGamers(String jsonText){
        gamers = new ArrayList<>();
        JSONParser j= new JSONParser();
        Map<String,Object> gamersListJson;
        try {
            gamersListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        
        
        List<Map<String,Object>> list = (List<Map<String,Object>>)gamersListJson.get("root");
        
        
        
        for(Map<String,Object> obj : list){
            Gamers g = new Gamers();
            float id = Float.parseFloat(obj.get("id").toString());
            g.setId((int)id);
            g.setName(obj.get("name").toString());
            gamers.add(g);
        }
        
                
                } catch (IOException ex) {
            
        }
        return gamers;
    }
    
    public ArrayList<Gamers> getAllGamers() {

String url = Statics.BASE_URL+"api/gamers";

req.setUrl(url);

req.setPost(false);

req.addResponseListener(new ActionListener<NetworkEvent>(){
    
    @Override 
        public void actionPerformed (NetworkEvent evt) {
            
            gamers = parseGamers(new String (req.getResponseData())); 
            req.removeResponseListener(this);
        }
        
        



});

NetworkManager.getInstance().addToQueueAndWait (req);

return gamers;

}
    
    
            
            
    
}
