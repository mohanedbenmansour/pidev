/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.ui.Form;
import entities.Product;
import java.util.ArrayList;
import services.ProductService;

/**
 *
 * @author mohan
 */
public class ListProductForm extends Form{
   /* public ListProductForm(){
        ArrayList<Product>list = ProductService.getInstance().afficherProducts();
        
        for(Publications pub : list) {
            
            String urlImage = "file:///C:/wamp64/www/PiDev/public/picture/"+pub.getImage() ;
            
            Image placeHolder = Image.createImage(1000,1000);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
            URLImage urlimg = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
            
            urlimg.fetch();
            addButton(urlimg,pub,res);
            
            ScaleImageLabel imagePub = new ScaleImageLabel(urlimg);
            Container containerImg = new Container();
            imagePub.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
            
        }
    }*/
}
