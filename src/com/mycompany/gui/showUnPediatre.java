/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompagny.Service.ServicePediatre;
import com.mycompany.Entite.Pediatre;
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.ToolBar;

/**
 *
 * @author Karim
 */
public class showUnPediatre {
    Form  f;
    User userinfo = User.getInstance();

    public showUnPediatre(int id) throws IOException  {
        f=new Form("Profil Pediatre",BoxLayout.y());
        Toolbar tool = new Toolbar();
        tool=f.getToolbar();
        tool.addCommandToLeftBar("Back", null,e->{ 
                     ListePediatre h = new ListePediatre();
                     h.getF().show();
                           } );
        
        
        //*******************************Recuperer le produit selectionné*************************************************
        
        ServicePediatre sc1=new ServicePediatre();
        Pediatre p=sc1.showPediatre(id);
        
        
   
         Container c1=new Container(BoxLayout.x());
         Container c2=new Container(BoxLayout.y());
         Container c4=new Container(BoxLayout.x());
         Container c3=new Container();
         
         c1.getStyle().setMargin(10, 0, 60, 0);
         //c2.getStyle().setBorder(Border.createLineBorder(2));
         

         
        //*******************************Les elements du container*********************************************************
       ImageViewer iv=new ImageViewer();
        
        iv.setImage(Image.createImage("/"+ p.getImage()).scaled(200, 200));

       SpanLabel l=new SpanLabel("Dr. "+p.getNom());
       SpanLabel l2=new SpanLabel("Email : "+p.getEmail());
       SpanLabel l3=new SpanLabel("Numero : "+p.getNum());
       SpanLabel l4=new SpanLabel("Specialite : "+p.getSpecialite());
       
        Button b = new Button("Rendez vous");
        Button b1 = new Button();
        if(sc1.VerfierLikes(p, userinfo)>0)
             { 
               b1.setText("je n'aime pas");
             }
        if(sc1.VerfierLikes(p, userinfo)==0)
             { 
               b1.setText("j'aime");
             }
        
       
       Label l5=new Label("Vues : "+p.getVues());
       l5.setUIID("font");
       Label l6=new Label("Likes : "+p.getLikes());
       l6.setUIID("font");
       Label l7=new Label("Rating : "+p.getRating());
       l7.setUIID("font");

         
        //*********************************Action sur le bouton*************************************************************
        
        c1.add(iv);
        c2.add(l);
        c2.add(l2);
        c2.add(l3);
        c2.add(l4);
        c3.add(b);
        c3.add(b1);
        c4.add(l5);
        c4.add(l6);
        c4.add(l7);        
 

         b.addActionListener(e->{ 
                   try {
                       PrendreRendezVous rv=new PrendreRendezVous(p.getId());
                       rv.getF().show();//showUnPediatre(p.getId());
                   } catch (IOException ex) {
                       //Logger.getLogger(ListePediatre.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
               });
         
         b1.addActionListener(e->{ 
             
             if(sc1.VerfierLikes(p, userinfo)==0)
             {  
               sc1.AjouterLikes(p, userinfo);
               p.setLikes(p.getLikes()+1);
               sc1.UpdateLikes(p); 
               b1.setText("je n'aime pas");
             }
             else
             {
                 sc1.RemoveLikes(p, userinfo);
                 p.setLikes(p.getLikes()-1);
                 sc1.UpdateLikes(p);
                 b1.setText("j'aime");
             }
             
             
               
               });

         
         f.add(c1);
         f.add(c2);
         f.add(c4);
         f.add(c3);
        
    
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    

    
}
