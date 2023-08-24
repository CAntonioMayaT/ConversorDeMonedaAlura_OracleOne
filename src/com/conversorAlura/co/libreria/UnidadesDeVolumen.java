/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conversorAlura.co.libreria;

/**
 *
 * @author VOLUNTARIOS
 */
public class UnidadesDeVolumen {
    double[] mililitros = {1, 0.001, 0.000001, 0.000001, 0.0000351951, 0.00000130795, 0.000000000239006};
    double[] centimetrosCubicos = {1, 0.001, 0.000001, 0.000001, 0.0000351951, 0.00000130795, 0.000000000239006};
    double[] litros = {1000, 1, 0.001, 0.000001, 0.0351951, 0.00130795, 0.000000239006};
    double[] decimetrosCubicos = {1000, 1, 0.001, 0.000001, 0.0351951, 0.00130795, 0.000000239006};
    double[] metrosCubicos = {1000000, 1000, 1, 0.001, 35.1951, 1.30795, 0.000239006};
    double[] galones = {3785.41, 3.78541, 0.00378541, 0.00000378541, 0.133681, 0.00495113, 0.000000859367};
    double[] decametrosCubicos = {10000000, 10000, 10, 0.01, 351.951, 13.0795, 0.00239006};
    double[] hectometrosCubicos = {1000000000, 1000000, 1000, 1, 35195.1, 1307.95, 0.239006};
    double[] kilometrosCubicos = {1000000000000.0, 1000000000, 1000000, 1000, 35195000, 1307950, 239.006};
    double[] gramos = {1, 0.001, 0.000001, 0.000000001, 0.00003527396, 0.00000220462, 0.00000000110231};
    double[] kilogramos = {1000, 1, 0.001, 0.000001, 0.03527396, 0.00220462, 0.00000110231};
    double[] libras = {453.592, 0.453592, 0.000453592, 0.000000453592, 0.015625, 0.00003125, 0.000000031081};
    String[] unidades = {"mL", "cm³", "L", "dm³", "m³", "gal", "dam³", "hm³", "km³", "g", "kg", "lb"};

    public double operar(String unidad1, String unidad2, String valorMedidaInicial) {
        int indexUnidad1 = -1; 
        int indexUnidad2 = -1; 
        double valorSecundario = 0;
        double valorMedida = Double.parseDouble(valorMedidaInicial);

        
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i].equals(unidad1)) {
                indexUnidad1 = i;
            } 
            if (unidades[i].equals(unidad2)) {
                indexUnidad2 = i;
            }
        }
       
        switch (indexUnidad1) {
            case 0 -> valorSecundario = mililitros[indexUnidad2];
            case 1 -> valorSecundario = centimetrosCubicos[indexUnidad2];
            case 2 -> valorSecundario = litros[indexUnidad2];
            case 3 -> valorSecundario = decimetrosCubicos[indexUnidad2];
            case 4 -> valorSecundario = metrosCubicos[indexUnidad2];
            case 5 -> valorSecundario = galones[indexUnidad2];
            case 6 -> valorSecundario = decametrosCubicos[indexUnidad2];
            case 7 -> valorSecundario = hectometrosCubicos[indexUnidad2];
            case 8 -> valorSecundario = kilometrosCubicos[indexUnidad2];
            case 9 -> valorSecundario = gramos[indexUnidad2];
            case 10 -> valorSecundario = kilogramos[indexUnidad2];
            case 11 -> valorSecundario = libras[indexUnidad2];
            default -> throw new IllegalArgumentException("Unidad no reconocida.");
        }
        
        return valorMedida * valorSecundario;
    }
    }