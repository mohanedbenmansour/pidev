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
import entities.CategoryProduct;
import entities.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
       String url=Statics.BASE_URL+"product/api/new?"+"name="+p.getName()+"&description="+p.getDescription()+"&image="+p.getImage()+"&price="+p.getPrice();
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
       System.out.println(productListJson);
       List<Map<String,Object>> list =(List<Map<String,Object>>)productListJson.get("root");
       


       for(Map<String,Object> obj : list){

           System.out.println(obj);
           



    Product p=new Product();
             p.setName(obj.get("name").toString());

             p.setImage(obj.get("image").toString());
                                     System.out.println(p);

             p.setPrice(obj.get("price").toString());
                                     System.out.println(p);

             p.setDescription(obj.get("description").toString());
                                     System.out.println(p);
                                                  p.setId((double) obj.get("id"));


             CategoryProduct c =new CategoryProduct("test");
             p.setCategory(c);
                        System.out.println(p);

             products.add(p);
       
       }
       }catch(IOException ex){
       
       }
       
       
       
       
       return products;
   }
   
   public ArrayList<Product> getAllProducts(){
        String url = Statics.BASE_URL+"product/api/sho";
               ConnectionRequest req=new ConnectionRequest(url);

        req.setUrl(url);
        req.setPost(false);
        
            req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {

                                        System.out.println(req.getResponseData());

                    products = parseProducts(new String(req.getResponseData()));
                    
                } catch (IOException ex) {
                }
                    req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return products;
    }
    
    
}
