/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import entities.CategoryEvent;
import entities.Event;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import services.EventService;

/**
 *
 * @author asus
 */
public class EventsForm extends Form {

    public EventsForm() {
        super("Events", BoxLayout.y());
        this.add(new InfiniteProgress());
        Button ajout=new Button("Ajouter événement");

            ajout.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new addEventForm().show();
            }
        });
        this.add(ajout);
        Display.getInstance().scheduleBackgroundTask(() -> {

            Display.getInstance().callSerially(() -> {
                this.removeAll();
                for (Event e : new EventService().ShowEvents()) {
                    this.add(addItem(e));
                }
                this.revalidate();
            });
        });
        /*
        this.getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : this.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                this.getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : this.getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();
                    String line2 = mb.getTextLine2();
                    mb.setUIIDLine1("libC");
                    mb.setUIIDLine2("btn");
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1
                            || line2 != null && line2.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                this.getContentPane().animateLayout(150);
            }
        }, 4);
          /*  
        this.getToolbar().addCommandToOverflowMenu("Add Event", null, ev -> {
         new AddEventForm().show();
        });
        this.getToolbar().addCommandToOverflowMenu("back", null, ev -> {
           new MyApplication().start();
        });
         */
    }

    public MultiButton addItem(Event e) {

        MultiButton m = new MultiButton();
        String urlImage = "http://127.0.0.1:8000/uploads/" + e.getImg();
        System.out.println(urlImage);
        DateFormat dF = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        m.setTextLine1(e.getName());
        m.setTextLine2(e.getLieu());
        m.setTextLine3(dF.format(e.getDateDeb()) + "   " + dF.format(e.getDateFin()));
        m.setTextLine4(String.valueOf(e.getPrix())+" TND");

        /*m.setEmblem(theme.getImage("round.png"));
        Image imge;
        EncodedImage enc;
        enc = EncodedImage.createFromImage(theme.getImage("round.png"), false);
        imge = URLImage.createToStorage(enc, url, url);*/
        //String urlImage = "file:/C:/Users/asus/Desktop/Integration 2.0/src/uploads/"+e.getImg();
        Image placeHolder = Image.createImage(80, 80);
        EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
        URLImage urlimg = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
        urlimg.fetch();
        m.setIcon(urlimg);

        m.addActionListener(a -> {

            Form f2 = new Form("Detail", BoxLayout.y());
            Image placeHolder2 = Image.createImage(150, 150);
            EncodedImage enc2 = EncodedImage.createFromImage(placeHolder2, false);
            URLImage urlimg2 = URLImage.createToStorage(enc2, urlImage, urlImage, URLImage.RESIZE_SCALE);
            urlimg2.fetch();
            f2.add(urlimg2).add("Nom : " + e.getName()).add("Lieu : " + e.getLieu()).add("Description : " + e.getDescription()).add("Date Debut: " + e.getDateDeb()).add("Date Fin: " + e.getDateFin()).add("Prix : " + e.getPrix()).add("Nb Participants : " + e.getNbP());

            Button btn_delete = new Button("Delete");
            Button btn_modifier = new Button("Modifier");

            // 1 tttbdl f integration b id _user 
            if (e.getUser() == 4)
            {
                f2.add(btn_delete);
                f2.add(btn_modifier);
            }

            btn_delete.addActionListener(aaa -> {
                EventService es = new EventService();
                es.deleteEvent(e.getId());

                Dialog.show("Delete", "Event deleted", "OK", null);
                new EventsForm().show();
            });

            btn_modifier.addActionListener(aaa -> {

                Form f_modifier = new Form("Modifier", BoxLayout.y());

                TextField name = new TextField("", "name");
                name.setText(e.getName());
                name.setUIID("TextFieldBlack");
                
                TextField description = new TextField("", "description");
                description.setText(e.getDescription());
                description.setUIID("TextFieldBlack");

                TextField prix = new TextField("", "prix");
                prix.setText(String.valueOf(e.getPrix()));
                prix.setUIID("TextFieldBlack");

                TextField lieu = new TextField("", "lieu");
                lieu.setText(e.getLieu());
                lieu.setUIID("TextFieldBlack");

                TextField nbP = new TextField("", "nb Participants",4,TextArea.NUMERIC);
                nbP.setText(String.valueOf(e.getNbP()));
                nbP.setUIID("TextFieldBlack");

                Picker dateDeb = new Picker();
                dateDeb.setType(Display.PICKER_TYPE_DATE_AND_TIME);
                dateDeb.setUIID("TextFieldBlack");

                Picker dateFin = new Picker();
                dateFin.setType(Display.PICKER_TYPE_DATE_AND_TIME);
                dateFin.setUIID("TextFieldBlack");

                
                f_modifier.add(name).add(lieu).add(description).add(prix).add(nbP).add(dateDeb).add(dateFin);

                Button capture = new Button("capture");
                Label image = new Label("image");
                Button valider = new Button("valider");
                capture.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String path = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
                        if (path != null) {
                            try {
                                Image img = Image.createImage(path);
                                image.setIcon(img);
                                image.setText(path);
                            } catch (IOException o) {
                                o.printStackTrace();
                            }
                        }
                    }
                });
                valider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        if (name.getText().length() == 0 || lieu.getText().length() == 0 || nbP.getText().length() == 0 || description.getText().length() == 0 || prix.getText().length() == 0) {
                            Dialog.show("alert", "please fill all the fields", new Command("ok"));
                        } else {
                            try {
                                CategoryEvent c = new CategoryEvent("test");
                                Event ee = new Event(e.getId(),name.getText(), description.getText(), lieu.getText(), image.getText(), Integer.parseInt(nbP.getText()), dateDeb.getDate(), dateFin.getDate(), Float.parseFloat(prix.getText()));

                                if (new EventService().modifierEvent(ee)) {
                                    Dialog.show("sucess", "event modified", new Command("ok"));
                                }
                                new EventsForm().show();
                            } catch (NumberFormatException e) {
                                Dialog.show("ERROR", "price must be a number", new Command("ok"));
                            }
                        }
                    }

                });
                  f_modifier.add(capture).add(valider);
                f_modifier.show();

            });
            
            Button participer = new Button ("Participer");
            participer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (new EventService().participate(e))
                {
                    Dialog.show("sucess","Participation done", new Command("ok"));
                    new EventsForm().show();
                }
            }
            });
            f2.add(participer);
            f2.show();
        });
        return m;

    }
/*
    public EventsForm() {
        setTitle("Events");
        setLayout(BoxLayout.y());
        ArrayList<Event> events = new EventService().ShowEvents();
        Button ajout = new Button("Ajouter événement");

        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new addEventForm().show();
            }
        });
        add(ajout);
        for (Event e : events) {
            TextArea name = new TextArea("Nom : " + e.getName());
            TextArea lieu = new TextArea("Lieu : " + e.getLieu());
            TextArea description = new TextArea("Description : " + e.getDescription());
            TextArea dateDeb = new TextArea("Date début : " + e.getDateDeb().toString());
            TextArea dateFin = new TextArea("Date Fin : " + e.getDateFin().toString());
            TextArea datePub = new TextArea("Date Publication : " + e.getDatePub().toString());
            //Label category=new Label("",e.getCategory().getName());
            TextArea prix = new TextArea("Prix : " + String.valueOf(e.getPrix()));
            TextArea nbP = new TextArea("Nbr Participants : " + String.valueOf(e.getNbP()));

            String urlImage = "file:/C:/Users/asus/Desktop/Integration 2.0/src/uploads/" + e.getImg();
            Image placeHolder = Image.createImage(100, 100);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
            URLImage urlimg = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
            urlimg.fetch();
            Label limg = new Label();
            limg.setIcon(urlimg);

            Button delete = new Button("X");

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EventService().deleteEvent(e.getId());
                    Dialog.show("sucess", "event " + e.getName() + " deleted", new Command("ok"));
                    new EventsForm().show();
                }
            });

            Container c = new Container();
            c.setLayout(BoxLayout.y());
            c.addAll(limg, name, lieu, description, dateDeb, dateFin, datePub, prix, nbP, delete);
            add(c);
        }
    }
*/
}
