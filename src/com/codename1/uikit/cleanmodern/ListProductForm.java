/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.Product;
import java.util.ArrayList;
import services.OrderService;
import services.ProductService;

/**
 *
 * @author mohan
 */
public class ListProductForm extends Form{
    public ListProductForm(Resources res){
        ArrayList<Product>list = ProductService.getInstance().getAllProducts();
        
       for(Product pub : list) {
            
            String urlImage = pub.getImage() ;
            
           Image placeHolder = Image.createImage(100,100);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
            URLImage urlimg = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
            
            urlimg.fetch();
          addPub(urlimg,pub,res);
            ScaleImageLabel imagePub = new ScaleImageLabel(urlimg);
            Container containerImg = new Container();
            imagePub.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
            
        }
    }
    
     
    private void addPub(Image img, Product pub, Resources res) {
        
        int height = Display.getInstance().convertToPixels(110.5f);
        int width = Display.getInstance().convertToPixels(104f);

        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        
        Container cnt = BorderLayout.west(image) ;
        
        TextArea taNom = new TextArea(pub.getName());
        TextArea ta1 = new TextArea("PRIX: "+pub.getPrice());
       // TextArea ta2 = new TextArea(pub.getImage());
        ta1.setUIID("newsTopLine");
        ta1.setEditable(false);
       
        taNom.setUIID("newsTopLine");
        taNom.setEditable(false);
        
            
        
        
        
        Label limg = new Label();
        limg.setIcon(img);
        
        Button test=new Button("order");
        //button supprimer
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);
        
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);
       
        //click delete icon
        test.addPointerPressedListener(l -> {
           
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("passer une commande","vous voulez passez cette publication?","Annuler","Oui")){
                dig.dispose();

            }
            else {
                dig.dispose();
                
                new OrderForm((int) pub.getId(),pub.getPrice()).show();
            }
            
        });
        
        cnt.add(BorderLayout.WEST, BoxLayout.encloseY(
                BoxLayout.encloseX(taNom),
                BoxLayout.encloseX(ta1),
                BoxLayout.encloseX(limg),
                 BoxLayout.encloseX(test)
               )
        
        );
        
        add(cnt);
       // add(createLineSeparator(0xffffff));
    }
}
