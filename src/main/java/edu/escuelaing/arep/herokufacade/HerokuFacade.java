/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.herokufacade;

import edu.escuelaing.arep.herokufacade.Client.ClientBrowser;
import static spark.Spark.*;

/**
 *
 * @author J. Eduardo Arias
 */
public class HerokuFacade {
    

    public static void main(String[] args) {
        port(getPort());
        get("/calculadora",(req, res) -> 
                "<h1> Calculadora Trigonometrica (Fachada)</h1>"
                + "<form action=\"/calcule\" method=\"get\">\n"
                + "  <label for=\"function\">Function: </label>\n"
                + "  <input type=\"text\" id=\"function\" name=\"function\"><br><br>\n"
                + "  <label for=\"number\">Number (Randians) :</label>\n"
                + "  <input type=\"number\" step=any id=\"number\" name=\"number\"><br><br>\n"
                + "  <input type=\"submit\" value=\"Submit\">\n"
                + "</form>");
        
        get("/calcule",  (req, res) -> {           
            return ClientBrowser.getPetition("https://www.google.com/");
        });
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }
   
    
    
   

}
