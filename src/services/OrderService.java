/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.events.ActionListener;
import entities.CategoryProduct;
import entities.Order;
import entities.Product;
import utils.Statics;
//pdf
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
/**
 *
 * @author mohan
 */
public class OrderService {
       public boolean resultOK;

       public boolean addOrder(Order o){
       String url=Statics.BASE_URL+"order/api/new?"+"status="+o.getStatus()+"&checkoutDate="+o.getCheckoutDate()+"&city="+o.getCity()+"&state="+o.getState()+"&totalPrice="+o.getTotalPrice()+"&userAdress="+o.getUserAdress()+"&zipCode="+o.getZipcode()+"&userPhone="+o.getUserPhone();
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
       
        public void orderPdf(Order o){
        try{

    Document document=new Document();

    PdfWriter.getInstance(document,Storage.getInstance().createOutputStream("d://ordrePdf.pdf"));
    document.open();
   Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

Chunk chunk = new Chunk("Your invoice ", font);

document.add(chunk);



document.add(new Paragraph("\n\n"));
chunk = new Chunk("userid: "+o.getId(), font);
document.add(chunk);
document.add(new Paragraph("\n"));
chunk = new Chunk("user adress: "+o.getUserAdress(), font);
document.add(chunk);
document.add(new Paragraph("\n"));
chunk = new Chunk("user phone :"+o.getUserPhone(), font);
document.add(chunk);
document.add(new Paragraph("\n"));
chunk = new Chunk("total price :"+o.getTotalPrice(), font);
document.add(chunk);

  
document.close();
System.out.println("pdf ajouter !");
        }catch(Exception e){
        System.out.println("Error PDF "+e);
        
        }
    
    }
        public void SendSms(int phonNumber){
          // Find your Account Sid and Token at twilio.com/user/account
 String ACCOUNT_SID = "AC548154ee267a4dc6665a64781ff57660";
String AUTH_TOKEN = "a80ff1b94e0f7b602ac91b3e0ae5ca2b";


    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21627789426"),
        new PhoneNumber("+18312188497"), 
        "your order has been comfirmed").create();

    System.out.println(message.getSid());
        
        }
}
