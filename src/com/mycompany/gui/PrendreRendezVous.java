/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import static com.codename1.messaging.Message.sendMessage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.spinner.DateTimeSpinner;
import com.codename1.ui.spinner.Picker;
import com.mycompagny.Service.ServicePediatre;
import com.mycompagny.Service.ServiceRendezVous;
import com.mycompany.Entite.Pediatre;
import com.mycompany.Entite.RendezVous;
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Karim
 */
public class PrendreRendezVous {

    Form f;

    public PrendreRendezVous(int id) throws IOException {
        f = new Form("");

        //*******************************Recuperer le produit selectionné*************************************************
        ServicePediatre sc1 = new ServicePediatre();
        Pediatre p = sc1.showPediatre(id);
        RendezVous r = new RendezVous();
          User userinfo = User.getInstance();

        Container c1 = new Container(BoxLayout.y());
        Container c2 = new Container(BoxLayout.x());

        //*******************************Les elements du container*********************************************************
          SpanLabel l=new SpanLabel("Nom : "+userinfo.getUsername());
          SpanLabel l2=new SpanLabel("Email : "+userinfo.getEmail());
          TextField t1 = new TextField();
        SpanLabel l3 = new SpanLabel("Date : ");
        Picker date = new Picker();
        date.setType(Display.PICKER_TYPE_DATE_AND_TIME);

        Button b = new Button("prendre rendez-vous");

          c1.add(l);
         c1.add(l2);
         c1.add(t1);
        c2.add(l3);
        c2.add(date);

        //*********************************Action sur le bouton*************************************************************
        b.addActionListener(e -> {

            

       
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(date.getDate()); // sets calendar time/date
        cal.add(Calendar.HOUR, 1);
           
         if (Dialog.show("Confirmation", "date : " + new SimpleDateFormat("yyyy-MM-dd").format(date.getDate()) + " time : " + new SimpleDateFormat("hh:mm:s").format(date.getDate()), "ok", "cancel")) {
                r.setIdUser(userinfo.getId());
                r.setIdPediatre(p.getId());
     
                String Dateee = new SimpleDateFormat("yyyy-MM-dd").format(date.getDate());
                //System.out.println("STRING TO DATE ==>" + Dateee);
                
                String Timeee = new SimpleDateFormat("hh:mm:ss").format(cal.getTime());
                //System.out.println("STRING TO Time ==>" + Timeee);
      
                r.setDateRendezVous(Dateee);
                r.setHeure(Timeee);
                //System.out.println("RR=>"+r);
                ServiceRendezVous srv = new ServiceRendezVous();
                
                if(srv.VerifRendezVous(p.getId(),date)>0)
                {
                    Dialog.show("verification", "cette date est reservee", "ok","cancel");
                }
                if(srv.VerifRendezVous(p.getId(),date)==0)
                {
                    srv.AjoutRendezVous(r);
                    srv.EnvoyerSmsRendezVous(p,t1.getText(),r.getDateRendezVous(),r.getHeure());
                    /*Message m = new Message("rendez vous");
                    sendMessage(new String[] {"abdelkarim.turki@gmail.com"},"hello", m);*/
                   
                    
                }

                   
               
         } 
         else 
         {

         }

        });

        f.add(c1);
        f.add(c2);
        f.add(b);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
