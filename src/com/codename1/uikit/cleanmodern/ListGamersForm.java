/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import services.GamerService;

/**
 *
 * @author Lenovo
 */
public class ListGamersForm extends Form{
    
    public ListGamersForm(Form previous){
        setTitle("List Gamers");
        
        SpanLabel sp=new SpanLabel();
        sp.setText(GamerService.getInstance().getAllGamers().toString());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
    
}
