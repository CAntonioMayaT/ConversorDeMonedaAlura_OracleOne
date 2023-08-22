
package com.conversorAlura.co.libreria;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsumidorAPI {
  
    protected String importAPI(String iso){
       StringBuilder importString = null;
        
    try {URL urlGet = new URL ("https://v6.exchangerate-api.com/v6/5d793011da943516f1303695/latest/" + iso);
    HttpURLConnection com =  (HttpURLConnection) urlGet.openConnection();
    com.setRequestMethod("GET");
    com.connect();
    int responseCode = com.getResponseCode();
    if (responseCode != 200) {
    throw new RuntimeException("ocurrio un error: " + responseCode);}
    else{
        importString = new StringBuilder();
        try (Scanner scann = new Scanner (urlGet.openStream())) {
            while(scann.hasNext()){
                importString.append(scann.nextLine());
            }
        }
    
    }
    } catch (IOException e) { System.err.println("Error al realizar la solicitud HTTP: " + e.getMessage());
        }
   
 return importString.toString();

}
}

      
  

