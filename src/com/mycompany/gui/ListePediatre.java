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
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompagny.Service.ServicePediatre;
import com.mycompany.Entite.Pediatre;
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Karim
 */
public class ListePediatre {
    Form  f; 
    User userinfo = User.getInstance();
    public ListePediatre()  {
        f=new Form("Liste Des Pediatre",BoxLayout.y());
     
           
         
        //*******************Recuperer la liste de produit de la base***************************************************
        
           ServicePediatre sp1=new ServicePediatre();
           ArrayList<Pediatre> list=sp1.showList();
           
           Container c4 = new Container(BoxLayout.x());
           Button b2= new Button("Top 3 ");
           c4.add(b2);
           b2.addActionListener(e->{ 
               ListePediatreTrier ls = new ListePediatreTrier();
               ls.getF().show();
               });
           f.add(c4);
       //********************************Parcourir la liste**************************************************************** 
        for(Pediatre p : list)
        {  
            Slider s = createStarRankSlider(p.getRating());
            s.setEditable(false);
            
           
               Container c1 =new Container(BoxLayout.x());
               Container c3 =new Container(BoxLayout.y());
               
              c1.getStyle().setBorder(Border.createLineBorder(2));
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(20, 20, 0, 0);

        //****************************les elements du containers********************************************************
               
               ImageViewer iv=new ImageViewer();
               
           try {
               iv.setImage(Image.createImage("/"+ p.getImage()).scaled(100, 100));
           } catch (IOException ex) {
                    System.out.println("err");
           }
              
               //Button b=new Button(image2.scaled(30,30));
               Button b=new Button("View Pediatre");
               
                       
               
               Label l2=new Label("Specialite"+ p.getSpecialite());

             //  l1.getStyle().set(0xC40C0C);
             
               c1.add(iv);
               c1.add(c3);
               c3.add(new SpanLabel("Nom"+ p.getNom()));
               c3.add(s);
               c3.add(l2);
               c3.add(b);
               
               
               
               
               
            //*******************************Action sur le bouton add*****************************************************
               
               b.addActionListener(e->{ 
                   try {
                       
                       p.setRating((int)sp1.calculerRating(p));
                       System.out.println("rating : "+p.getRating()+"likes : "+p.getLikes()+"vues : "+p.getVues());
                       sp1.UpdateRating(p);
                       if(sp1.VerfierVues(p, userinfo)==0)
                       {
                         //System.out.println("view"+p.getVues());
                         p.setVues(p.getVues()+1);
                         //System.out.println("view"+p.getVues());
                         sp1.UpdateVues(p);
                         sp1.AjouterVues(p, userinfo);  
                       }
                       showUnPediatre sc=new showUnPediatre(p.getId());
                       sc.getF().show();//showUnPediatre(p.getId());
                   } catch (IOException ex) {
                       //Logger.getLogger(ListePediatre.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
               });
               
       
           
            f.add(c1);
            
        }
        
        
        
        
    }
    
     private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private Slider createStarRankSlider(int i) {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(5);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        starRank.setProgress(i);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
