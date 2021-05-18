package com.codename1.uikit.cleanmodern;


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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohan
 */
public class addProductForm extends Form {
    public addProductForm (){
        setTitle("add new product");
        setLayout(BoxLayout.y());
        TextField name=new TextField("","name");
        TextField description=new TextField("","description");
        TextField price=new TextField("","price");
        Button valider=new Button("valider");
        
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(name.getText().length()==0||description.getText().length()==0||price.getText().length()==0 ){
                Dialog.show("alert","please fill all the fields",new Command("ok"));
                
                }
                
                else {try{
                    //String name, String description, String price, String image, CategoryProduct category
                    CategoryProduct c=new CategoryProduct("test");
                Product p=new Product(name.getText(),description.getText(),price.getText(),"test",c);
                }catch(NumberFormatException e){
                Dialog.show("ERROR","price must be a number", new Command("ok"));
                }
                
                }
                
            }
        
        });
        
        addAll(name,description,price,valider);
    }

}
