/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.components.InteractionDialog;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Pediatre;
import com.mycompany.Entite.RendezVous;
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karim
 */
public class ServiceRendezVous {
    
     public void AjoutRendezVous(RendezVous r) 
    
    {
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/ajouterRendezVous.php?idUser="+r.getIdUser()+"&idPediatre="+r.getIdPediatre()+"&dateRendezVous="+new SimpleDateFormat("yyyy-MM-dd").format(r.getDateRendezVous())+"&nom="+r.getNom()+"&prenom="+r.getPrenom()+"&heure="+new SimpleDateFormat("hh:mm:ss").format(r.getHeure()));

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }
     
     
      public void EnvoyerSmsRendezVous(Pediatre p,String num,String date,String heure) 
    
    {
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/projetPI3/web/app_dev.php/Echange?num="+num+"&nomPediatre="+p.getNom()+"&date="+date+"&heure="+heure);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }
     
     public int VerifRendezVous(int idPediatre,Picker DateRendezVous) 
    
    {
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(DateRendezVous.getDate()));
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(DateRendezVous.getDate()); // sets calendar time/date
        cal.add(Calendar.MINUTE, -30); // adds one hour
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(cal.getTime())); // returns new date object, one hour in the future
        Calendar cal2 = Calendar.getInstance(); // creates calendar
        cal2.setTime(DateRendezVous.getDate()); // sets calendar time/date
        cal2.add(Calendar.MINUTE, 30); // adds one hour
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(cal2.getTime())); // returns new date object, one hour in the future
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(DateRendezVous.getDate()));
        
        
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/VerifierRendezVous.php?idPediatre="+idPediatre+"&dateRendezVous="+new SimpleDateFormat("yyyy-MM-dd").format(DateRendezVous.getDate())+"&heure1="+new SimpleDateFormat("hh:mm:ss").format(cal.getTime())+"&heure2="+new SimpleDateFormat("hh:mm:ss").format(cal2.getTime()));
        List<Integer> liste = new ArrayList<Integer>();
        con.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Pediatres = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Pediatres.put("Pediatre", Pediatres.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Pediatres.get("Pediatre");
                    
                    System.out.println(list);
                    System.out.println(Pediatres);
                    
                    for (Map<String, Object> obj : list) {

                      int count = Integer.parseInt(obj.get("count").toString());
                      liste.add(count);

                    }
                } catch (IOException ex) {
                }  
           
            }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return liste.get(0);
    
    }
}
