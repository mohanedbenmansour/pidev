/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.CategoryProduct;
import entities.Order;
import entities.Product;
import services.OrderService;
import services.ProductService;

/**
 *
 * @author mohan
 */
public class OrderForm extends Form{
    public OrderForm(int id,String price){

 setTitle("your order");
        setLayout(BoxLayout.y());
        TextField address=new TextField("","adress");
        TextField phone=new TextField("","phone");
        TextField status=new TextField("","status");
        TextField state=new TextField("","state");
                TextField city=new TextField("","city");

        TextField zipcode=new TextField("","zipcode");

        Label prix=new Label("prix");
prix.setText("total price: "+price);
        address.setUIID("TextFieldBlack");
        phone.setUIID("TextFieldBlack");
        status.setUIID("TextFieldBlack");
        state.setUIID("TextFieldBlack");
        zipcode.setUIID("TextFieldBlack");
        prix.setUIID("TextFieldBlack");
        
        Button valider=new Button("valider");

  valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(address.getText().length()==0||phone.getText().length()==0||status.getText().length()==0||state.getText().length()==0||zipcode.getText().length()==0 ){
                Dialog.show("alert","please fill all the fields",new Command("ok"));
                
                }
                
                else {try{
                    //String name, String description, String price, String image, CategoryProduct category
                    CategoryProduct c=new CategoryProduct("test");
// public Order(int userId, int zipcode, int userPhone, int totalPrice, String userAdress, String checkoutDate, String status, String city, String state) {
int zip = Integer. parseInt(zipcode.getText());
int p = Integer. parseInt(phone.getText());

                Order o=new Order(1,zip,p,price,address.getText(),"5-19-2021",status.getText(),city.getText(),state.getText());
                                    OrderService or =new OrderService();
            
                or.SendSms(o.getUserPhone());

                if (new OrderService().addOrder(o)){
                or.orderPdf(o);
  Dialog.show("sucess","order added", new Command("ok"));
                }

                }catch(NumberFormatException e){
                Dialog.show("ERROR","price must be a number", new Command("ok"));
                }
                
                }
                
            }
        
        });
        
        addAll(address,phone,status,state,zipcode,prix,valider);


    }
}
