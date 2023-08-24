package com.conversorAlura.co.libreria;

public class UnidadesDeMedida {
 
    double[] milimetros = {1, 0.1, 0.001, 0.000001, 0.0393701, 0.00109361, 0.000000621371};
    double[] metros = {1000, 100, 1, 0.001, 39.3701, 1.09361, 0.000621371};   
    double[] pulgadas = {25.4, 2.54, 0.0254, 0.0000254, 0.0277778, 1, 0.000015783};
    double[] centimetros = {10, 0.01, 0.00001, 0.393701, 0.0109361, 0.00000621371};
    double[] kilometros = {1000000, 100000, 1000, 1, 39370.1, 1093.61, 0.621371};
    double[] yardas = {914.4, 91.44, 0.9144, 0.0009144, 36,1, 0.0005};
    double[] millas = {1609344, 160934.4, 1609.344, 1.609344, 63360, 1760, 1};
    String[] medidas = {"mm", "cm", "m", "km", "in", "yd", "mi"};

    public double operar (String medida1, String medida2, String valorMedidaInicial){
        int indexMedida1 = -1; 
        int indexMedida2 = -1; 
        double valorSecundario;
        double valorMedida = Double.parseDouble(valorMedidaInicial);
      for (var i = 0; i < medidas.length; i++) {
        if (medidas[i].equals(medida1)) {indexMedida1 = i;} 
        if (medidas[i].equals(medida2)) {indexMedida2 = i;}
       }
       
        switch (indexMedida1) {
            case 0 -> valorSecundario = milimetros[indexMedida2];
            case 1 -> valorSecundario = centimetros[indexMedida2];
            case 2 -> valorSecundario = metros[indexMedida2];
            case 3 -> valorSecundario = kilometros[indexMedida2];
            case 4 -> valorSecundario = pulgadas[indexMedida2];
            case 5 -> valorSecundario = yardas[indexMedida2];
            case 6 -> valorSecundario = millas[indexMedida2];
            default -> throw new AssertionError();
        }
        
        
               
               
    return valorMedida * valorSecundario;
    }
}
