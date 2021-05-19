/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author mohan
 */
public class ShopForm extends Form{
    public ShopForm(Resources res){
        setTitle("shop");
        setLayout(BoxLayout.y());
        
        add(new Label("choose an option"));
 Button btnViewShop = new Button("View Shop");  
 Button btnAddProduct = new Button("add Product");        
 Button btnViewProducts = new Button("View Products");        
   

 btnAddProduct.addActionListener(e-> new addProductForm().show());
  btnViewShop.addActionListener(e-> new ListProductForm(res).show());

addAll(btnViewShop,btnAddProduct);

   
    }
 
}
