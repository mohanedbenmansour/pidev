/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.CategoryProduct;
import utils.Statics;

/**
 *
 * @author mohan
 */
public class CategoryProductService {
    public boolean resultOK;
   
   public boolean addCategory(CategoryProduct c){
       String url=Statics.BASE_URL+"CategoryProduct/new?"+"name="+c.getName();
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
