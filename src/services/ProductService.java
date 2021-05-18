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
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import entities.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author mohan
 */
public class ProductService {
     public ArrayList<Product> products;
     
    public static ProductService instance = null ;
     public static ProductService getInstance() {
        if(instance == null)
            instance = new ProductService();
        return instance;
    }
     
     
     
     
    
        
        
        
        
   public boolean resultOK;
   
   public boolean addProduct(Product p){
       String url=Statics.BASE_URL+"product/new?"+"name="+p.getName()+"&description="+p.getDescription()+"&image="+p.getImage()+"&price="+p.getPrice();
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
   
   public ArrayList<Product> parseProducts(String jsonText) throws IOException{
       try{
   products=new ArrayList<>();
       JSONParser j =new JSONParser();
       Map <String,Object> productListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
       
       List<Map<String,Object>> List =(List<Map<String,Object>>)productListJson.get("root");
       
       for(Map<String,Object>: List){
       Product p=new Product();
       }
       }catch(IOException ex){
       
       }
       
       
       
       
       return products;
   }
    
    
}
