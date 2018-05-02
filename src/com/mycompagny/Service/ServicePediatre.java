/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Pediatre;
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Karim
 */
public class ServicePediatre {
    User u = User.getInstance();
    public ArrayList<Pediatre> showList() 
    
    {
        ArrayList<Pediatre> listPediatre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/showListPediatre.php");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Pediatres = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Pediatres.put("Pediatre", Pediatres.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Pediatres.get("Pediatre");

                    for (Map<String, Object> obj : list) {

                        Pediatre p = new Pediatre();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        
                        p.setNom(obj.get("nom").toString());
                        p.setEmail(obj.get("email").toString());
                        p.setSpecialite(obj.get("specialite").toString());
                        p.setRating(Integer.parseInt(obj.get("rating").toString()));
                        p.setAdresse(obj.get("adresse").toString());
                        p.setDemande(Integer.parseInt(obj.get("demande").toString()));
                        p.setImage(obj.get("image").toString());
                        p.setLikes(Integer.parseInt(obj.get("likes").toString()));
                        p.setVues(Integer.parseInt(obj.get("vues").toString()));
                        p.setNum(Integer.parseInt(obj.get("num").toString()));
                        p.setNbJetons(Integer.parseInt(obj.get("nbJetons").toString()));
                        p.setId((int) id);


                        
                        listPediatre.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPediatre;
    }
    
    public ArrayList<Pediatre> showListTrier() 
    
    {
        ArrayList<Pediatre> listPediatre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/showListPediatreTrier.php");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Pediatres = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Pediatres.put("Pediatre", Pediatres.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Pediatres.get("Pediatre");

                    for (Map<String, Object> obj : list) {

                        Pediatre p = new Pediatre();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        
                        p.setNom(obj.get("nom").toString());
                        p.setEmail(obj.get("email").toString());
                        p.setSpecialite(obj.get("specialite").toString());
                        p.setRating(Integer.parseInt(obj.get("rating").toString()));
                        p.setAdresse(obj.get("adresse").toString());
                        p.setDemande(Integer.parseInt(obj.get("demande").toString()));
                        p.setImage(obj.get("image").toString());
                        p.setLikes(Integer.parseInt(obj.get("likes").toString()));
                        p.setVues(Integer.parseInt(obj.get("vues").toString()));
                        
                        p.setNum(Integer.parseInt(obj.get("num").toString()));
                        p.setNbJetons(Integer.parseInt(obj.get("nbJetons").toString()));
                        p.setId((int) id);


                        
                        listPediatre.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPediatre;
    }
    
   
    
    public Pediatre showPediatre(int id)
    {
        
        Pediatre p = new Pediatre();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/showProfilPediatre.php?id="+id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Pediatres = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Pediatres.put("pediatre", Pediatres.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Pediatres.get("pediatre");

                    for (Map<String, Object> obj : list) {

                        ///Pediatre p = new Pediatre();
                         float id = Float.parseFloat(obj.get("id").toString());
                        p.setNom(obj.get("nom").toString());
                        p.setEmail(obj.get("email").toString());
                        p.setSpecialite(obj.get("specialite").toString());
                        p.setRating(Integer.parseInt(obj.get("rating").toString()));
                        p.setAdresse(obj.get("adresse").toString());
                        p.setDemande(Integer.parseInt(obj.get("demande").toString()));
                        p.setImage(obj.get("image").toString());
                        p.setLikes(Integer.parseInt(obj.get("likes").toString()));
                        p.setVues(Integer.parseInt(obj.get("vues").toString()));
                        
                        p.setNum(Integer.parseInt(obj.get("num").toString()));
                        p.setNbJetons(Integer.parseInt(obj.get("nbJetons").toString()));
                        p.setId((int) id);


                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return p;
    }
    
    public double calculerRating(Pediatre p )
    {
        double rating = ((double) p.getLikes()/(double) p.getVues())*5;
        return rating;       
    }
    
    public void UpdateRating(Pediatre p)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/rating.php?id="+p.getId()+"&rating="+p.getRating());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    public void RemoveLikes(Pediatre p,User u)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/removeLikes.php?idUser="+u.getId()+"&idPediatre="+p.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void AjouterLikes(Pediatre p,User u)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/AjouterLikes.php?idUser="+u.getId()+"&idPediatre="+p.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void AjouterVues(Pediatre p,User u)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/AjouterVues.php?idUser="+u.getId()+"&idPediatre="+p.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
      public void UpdateVues(Pediatre p)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/updateVues.php?id="+p.getId()+"&vues="+p.getVues());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void UpdateLikes(Pediatre p)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/UpdateLikes.php?id="+p.getId()+"&likes="+p.getLikes());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public int VerfierLikes(Pediatre p,User u)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/verifierLikes.php?id="+p.getId()+"&idPediatre="+p.getId()+"&idUser="+u.getId());
        List<Integer> liste = new ArrayList<Integer>();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
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

     
     public int VerfierVues(Pediatre p,User u)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/verifierVues.php?id="+p.getId()+"&idPediatre="+p.getId()+"&idUser="+u.getId());
        List<Integer> liste = new ArrayList<Integer>();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
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
