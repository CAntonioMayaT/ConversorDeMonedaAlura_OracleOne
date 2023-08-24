/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conversorAlura.co.libreria;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author carolina
 */
public class realizarLlamadoPag {
    
    public void Llamado(JPanel p, JPanel content){
    p.setSize(600,500);
    p.setLocation(0,0);
    
    content.removeAll();
    content.add(p, BorderLayout.CENTER);
    content.revalidate();
    content.repaint();          
    }
};
