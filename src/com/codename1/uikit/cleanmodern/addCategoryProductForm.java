/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.CategoryProduct;
import entities.Product;
import services.CategoryProductService;
import services.ProductService;

/**
 *
 * @author mohan
 */
public class addCategoryProductForm extends Form {
     public addCategoryProductForm (){
        setTitle("add new category");
        setLayout(BoxLayout.y());
        TextField name=new TextField("","name");
     
        Button valider=new Button("valider");
        
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(name.getText().length()==0){
                Dialog.show("alert","please fill all the fields",new Command("ok"));
                
                }
                
                else {try{
                    //String name, String description, String price, String image, CategoryProduct category
                    CategoryProduct c=new CategoryProduct(name.getText());
                
                if (new CategoryProductService().addCategory(c))
  Dialog.show("sucess","category added", new Command("ok"));

                }catch(NumberFormatException e){
                Dialog.show("ERROR","price must be a number", new Command("ok"));
                }
                
                }
                
            }
        
        });
        
        addAll(name,valider);
    }

   
}
