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
import java.util.List;
import com.codename1.ui.events.ActionListener;
import entities.Event;
import entities.CategoryEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import utils.Statics;

/**
 *
 * @author asus
 */
public class EventService {
    public boolean resultOK;
    public boolean resultOK2;
    private ArrayList<Event> events;
   
   public boolean addEvent(Event e){
       String url=Statics.BASE_URL+"api/event/new?"+"name="+e.getName()+"&lieu="+e.getLieu()+"&description="+e.getDescription()+"&img="+e.getImg()+"&prix="+e.getPrix()+"&nbP="+e.getNbP()+"&dateDeb="+e.getDateDeb()+"&dateFin="+e.getDateFin();
       ConnectionRequest req=new ConnectionRequest(url);
       
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
            resultOK=req.getResponseCode()==200;
           }  
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
   }
   public void deleteEvent(int id){
       String url=Statics.BASE_URL+"api/event/delete/"+id;
       ConnectionRequest req=new ConnectionRequest(url);
       req.setUrl(url);
       req.setPost(false);
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
            req.removeResponseListener(this);
           }  
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
   }
   
   public boolean modifierEvent(Event e){
       String url=Statics.BASE_URL+"api/event/edit/"+e.getId()+"?name="+e.getName()+"&lieu="+e.getLieu()+"&description="+e.getDescription()+"&img="+e.getImg()+"&prix="+e.getPrix()+"&nbP="+e.getNbP()+"&dateDeb="+e.getDateDeb()+"&dateFin="+e.getDateFin();
       ConnectionRequest req=new ConnectionRequest(url);
       req.setUrl(url);
       req.setPost(false);
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
            req.removeResponseListener(this);
            resultOK=req.getResponseCode()==200;

           }  
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
   }
   
   public ArrayList<Event> ShowEvents(){
       String url=Statics.BASE_URL+"api/event";
       ConnectionRequest req=new ConnectionRequest(url);
       req.setUrl(url);
       req.setPost(false);
       
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
               try {
                   events = parseEvents(new String(req.getResponseData()));
               } catch (IOException | ParseException ex) { 
               }
                req.removeResponseListener(this);
           }  
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
       return events;
   }
   
   public ArrayList<Event> parseEvents(String jsonText) throws IOException, ParseException{
       try{
           events = new ArrayList<>();
           JSONParser j =new JSONParser();

           Map <String,Object> eventsListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           List<Map<String,Object>> List =(List<Map<String,Object>>)eventsListJson.get("root");
            
           System.out.println(eventsListJson);

           for ( Map <String,Object> obj : List) {
               //System.out.println(obj);
               float id = Float.parseFloat(obj.get("id").toString());
               //System.out.println("1"+obj.get("name").toString());
               String name = obj.get("name").toString();
               //System.out.println("2"+obj.get("lieu").toString());
               String lieu = obj.get("lieu").toString();
               //System.out.println("3"+obj.get("description").toString());
               String description = obj.get("description").toString();
               //System.out.println("4"+obj.get("img").toString());
               String img = obj.get("img").toString();
               float nbP = Float.parseFloat(obj.get("nbParticipants").toString());
               float prix = Float.parseFloat(obj.get("prix").toString());
               DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
               Date dateDeb = format.parse(obj.get("dateDebut").toString());
               Date dateFin = format.parse(obj.get("dateFin").toString());
               Date datePub = format.parse(obj.get("datePub").toString());

               float idCat=0;
               Map<String, Object> map1 = ((Map<String, Object>) obj.get("Category"));
                for (Entry<String, Object> entry : map1.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    
                    if(key.equals("id"))
                    {
                       idCat = Float.parseFloat(value.toString());
                    }
                   
                    
                }
                float idUser=0;
               Map<String, Object> map2 = ((Map<String, Object>) obj.get("user"));
                for (Entry<String, Object> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    
                    if(key.equals("id"))
                    {
                       idUser = Float.parseFloat(value.toString());
                    }
                   
                    
                }

               events.add(new Event((int)id,name,description,lieu,img,(int)nbP,dateDeb,dateFin,datePub,prix,(int)idCat,(int)idUser));
           }
           
       }catch(IOException ex){
           
       }
       return events;
   }
   
   public boolean participate(Event e){
       String url=Statics.BASE_URL+"api/event/participate/"+e.getId()+"/4";
       ConnectionRequest req=new ConnectionRequest(url);
       
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
            resultOK=req.getResponseCode()==200;
           }  
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
   }
}
