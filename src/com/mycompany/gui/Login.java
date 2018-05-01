/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompagny.Service.ServiceUser;
import com.mycompany.Entite.User;
import java.io.IOException;

/**
 *
 * @author Karim
 */
public class Login {
    Form f;
    User userinfo;
    
    public Login()
    {
        f=new Form("Bienvenue",BoxLayout.y());
        TextField username=new TextField();
        TextField Password = new TextField();
        Button Login=new Button("Login");
        ServiceUser us=new ServiceUser();
        f.add(username);
        f.add(Password);
        f.add(Login);
        
         Login.addActionListener(e -> {
             User u1=us.CheckLogin(username.getText(),Password.getText());
  
            
                          System.out.println("USER ===> "+u1.getUsername()+","+u1.getId());
                            User.setInstance(u1);
             if(u1!=null)
             {
                 ListePediatre h;
                 try {
                     h = new ListePediatre();
                     h.getF().show();
                 } catch (Exception ex) {
                     System.out.println("ERREUR DANS REDIRECTION APRES LOGIN ");                 }
                 
             }

            });
        
        f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
