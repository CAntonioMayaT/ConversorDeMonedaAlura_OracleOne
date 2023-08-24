package com.conversorAlura.co.libreria;
import com.conversorAlura.co.libreria.ConsumidorAPI;
/**
 *
 * @author VOLUNTARIOS
 */
public class Conversion {
    
    public String valorExchange (String divisaBase, String divisaSecundaria){
       if(divisaBase.equals(divisaSecundaria)) {return "1";} 
       else{    
       ConsumidorAPI api = new ConsumidorAPI();
       
        String apiString = api.importAPI(divisaBase);
        String exchangeValue = "";

        int startIndex = apiString.indexOf(divisaSecundaria);
        if (startIndex != -1) { 
            int temporalyIndex = startIndex + 5;
            int finalIndex = apiString.indexOf(",", temporalyIndex);
            
            if (finalIndex != -1){
                exchangeValue = apiString.substring(temporalyIndex, finalIndex);
            }
        }
    
    
    return exchangeValue;}
    }
 
    public String resultadoConversion (double valorIngresado, double valorCambio){
        double valor = valorIngresado *  valorCambio;
        String valorConvertido = String.valueOf(valor);
        return valorConvertido;
    }
}
    
