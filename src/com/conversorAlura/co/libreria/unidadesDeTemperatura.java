package com.conversorAlura.co.libreria;

public class UnidadesDeTemperatura {
   double valorFinal;
   String[] medidas = {"C", "K", "F"};

    public double operar (String medida1, String medida2, String valorMedidaInicial){
        int indexMedida1 = -1; 
        int indexMedida2 = -1; 
        double valorMedida = Double.parseDouble(valorMedidaInicial);

      for (var i = 0; i < medidas.length; i++) {
        if (medidas[i].equals(medida1)) {indexMedida1 = i;} 
        if (medidas[i].equals(medida2)) {indexMedida2 = i;}
       }
       
      double constante = 1.125;
      double constante2 = 0.5555555556;
      double valorInter;
        switch (indexMedida1) {
            case 0 -> {
                switch (indexMedida2) {
                    case 0 -> valorFinal = valorMedida;
                    case 1 -> valorFinal = valorMedida + 273.15;
                    case 2 -> valorFinal = (valorMedida * constante) + 32;
                    default -> throw new AssertionError();
                }  }

            case 1 -> {
                switch (indexMedida2) {
                    case 0 -> valorFinal = valorMedida - 273.15;
                    case 1 -> valorFinal = valorMedida;
                    case 2 -> {
                        valorInter = (valorMedida - 273.15) * constante;
                        valorFinal = valorInter + 32;
                    }
                    default -> throw new AssertionError();
                }  }

            case 2 -> {
                switch (indexMedida2) {
                    case 0 -> valorFinal = (valorMedida - 32) * constante2;
                    case 1 -> {
                        valorInter = (valorMedida - 32) * constante2;
                        valorFinal = valorInter + 273.15;
                    }
                    case 2 -> {
                        valorFinal = valorMedida;
                        break;
                    }
                    default -> throw new AssertionError();
                }
                
               
           }

    }
    return valorFinal;
}

}