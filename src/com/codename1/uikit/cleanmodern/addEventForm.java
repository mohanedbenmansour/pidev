/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import entities.CategoryEvent;
import entities.Event;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import services.EventService;

/**
 *
 * @author asus
 */
public class addEventForm extends Form{
    public addEventForm (){
        setTitle("add new event");
        setLayout(BoxLayout.y());
        TextField name=new TextField("","name");
        name.setUIID("TextFieldBlack");
        TextField description=new TextField("","description");
        description.setUIID("TextFieldBlack");
        TextField prix=new TextField("","prix");
        prix.setUIID("TextFieldBlack");
        TextField lieu=new TextField("","lieu");
        lieu.setUIID("TextFieldBlack");
        TextField nbP=new TextField("","nb Participants");
        nbP.setUIID("TextFieldBlack");
        Picker dateDeb = new Picker();
        dateDeb.setType(Display.PICKER_TYPE_DATE_AND_TIME);
        dateDeb.setUIID("TextFieldBlack");
        Picker dateFin = new Picker();
        dateFin.setType(Display.PICKER_TYPE_DATE_AND_TIME);  
        dateFin.setUIID("TextFieldBlack");

        Button capture=new Button("capture");
        Label image=new Label("image");
        Button valider=new Button("valider");
        capture.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
           String path=Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
           if(path!=null){
           try{
           Image img=Image.createImage(path);
                    image.setIcon(img);
                    image.setText(path);
           }catch(IOException o){               
               o.printStackTrace();
            }
           }
          } 
        });
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(name.getText().length()==0||lieu.getText().length()==0||nbP.getText().length()==0||description.getText().length()==0||prix.getText().length()==0 ){
                Dialog.show("alert","please fill all the fields",new Command("ok"));
                }
                else {
                    try{
                        //CategoryEvent c=new CategoryEvent("test");
                        Event e=new Event(name.getText(),description.getText(),lieu.getText(),image.getText(),Integer.parseInt(nbP.getText()),dateDeb.getDate(),dateFin.getDate(),Float.parseFloat(prix.getText()),1);

                        if (new EventService().addEvent(e))
                            Dialog.show("sucess","event added", new Command("ok"));
                            new EventsForm().show();
                    }catch(NumberFormatException e){
                        Dialog.show("ERROR","price must be a number", new Command("ok"));
                    }
                }
            }
        
        });
        addAll(name,description,lieu,dateDeb,dateFin,nbP,prix,capture,valider,image);
    }
    
}
