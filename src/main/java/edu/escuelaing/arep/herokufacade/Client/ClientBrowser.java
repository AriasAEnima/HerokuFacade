/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.herokufacade.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J. Eduardo Arias
 */
public class ClientBrowser {
    
    public static void main(String[] args){
        System.out.println(getPetition("http://localhost:4567/calcule?function=sin&number=7.5"));
    }
    
    public static String getPetition(String urls) {
        String ans = "";
        try {
            URL url = new URL(urls);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream is = con.getInputStream();
            BufferedReader in = null;
            String inputLine;
            StringBuilder body;
            in = new BufferedReader(new InputStreamReader(is));
            body = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();
            ans = body.toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientBrowser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
    
   
}
