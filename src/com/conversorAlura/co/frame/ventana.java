package com.conversorAlura.co.frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.conversorAlura.co.libreria.Conversion; 
import javax.swing.JOptionPane;

public class ventana extends JFrame {
    public JPanel panel; 
    JComboBox listaDivisa1;
    JComboBox listaDivisa2;
    JPanel resultadoPanel;
    JLabel resultadoLabel;
    JTextField valor;
    JPanel resultadoPanel2;
    JLabel resultadoLabel2;
    String valorIngresado;
    
    public ventana() {  
              
       this.setSize(500, 500); //Establecemos el tamaño de la ventana.
       this.setMinimumSize(new Dimension(200,200)); //Establecemos el tamaño minimo de la ventana para dispositivos en donde la resolución del windows sea menor por defecto.
       this.setLocationRelativeTo(null); //Establecemos la posición relativa de la ventana al momento inicial de la ejecució, al estar en NULL definimos que este centrada. 
       this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Establecemos el comando que realizamos al darle X a la ventana, pues por defecto la emulación sigue corriendo cuando cerramos la ventana. En este caso al tener "EXIT_ON_CLOSE" se detiene la ejecución al dar clic en la X en la ventana.  
       this.setTitle("Conversor de monedas ALURA"); //Establecemos un titulo para la ventana en la barra de Estado. 
       
       iniciarComponentes(); //Ejecutamos la función iniciarComponente que es la que nos crea los elementos.
    }
    
    private void iniciarComponentes(){
        colocarPaneles(); //Ejecutamos la función colocarPaneles que es la que nos crea el Jpanel.
        colocarEtiquetas(); //Ejecutamos la función colocarEtiquetas que es la que nos crea las etiquetas.
        colocarBotones(); //Ejecutamos la función colocarBotones que es la que nos crea los botones.
        colocarCajaValor(); //Ejecutamos la función colocarCajaValor que es la que nos crea la caja para ingresar el valor.
        colocarListasDesplegables(); //Ejecutamos la función colocarListasDesplegables que es la que nos crea la caja las listas desplegables para seleccionar la divisa.
        colocarResultado();//Ejecutamos la función colocarResultado que es la que nos crea la caja donde se mostrara el label que tendra el valor.
    }
    
    private void colocarPaneles() {
        panel = new JPanel();//Hacemos el llamado de Jpanel y lo instanciamos.

        panel.setBackground(Color.WHITE); //Establecemos un color para el fondo del panel.
        panel.setLayout(null);
        this.getContentPane().add(panel); //Agregamos el panel llamado "panel" a la ventana a través del getContentPane y add.
        }
    
    public void colocarEtiquetas () {
        JLabel etiqueta = new JLabel();
        JLabel etiqueta1 = new JLabel();
        etiqueta.setText("CONVERSOR DE MONEDAS");
        etiqueta.setBounds(165, 50, 200, 150);
        etiqueta1.setText("Seleccióne la divisa a convertir:");
        
        etiqueta1.setBounds(150, 100, 200, 150);
        JLabel imagen1 = new JLabel();
        ImageIcon img = new ImageIcon("coins.png");
        
        imagen1.setBounds(192, 5, 100, 100 );
        imagen1.setIcon(new ImageIcon(img.getImage().getScaledInstance(imagen1.getWidth(),imagen1.getHeight(), Image.SCALE_AREA_AVERAGING)));
        
        panel.add(imagen1);
        panel.add(etiqueta);
        panel.add(etiqueta1);
    }

    public void colocarBotones() {
        JButton botton1 = new JButton();
        JButton botton2 = new JButton();
        ImageIcon img2 = new ImageIcon("Arrows.png");
        
        botton1.setBounds(220, 220, 40, 40);
        botton1.setEnabled(true);
        botton1.setBackground(Color.white);
        botton1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(botton1.getWidth(), botton1.getHeight(),Image.SCALE_SMOOTH)));
        
        botton2.setText("Convertir");
        botton2.setBounds(180, 400, 100, 25);
        
          botton1.addActionListener((ActionEvent e) -> {
              int selectedDivisa1Index = listaDivisa1.getSelectedIndex();
              int selectedDivisa2Index = listaDivisa2.getSelectedIndex();
              
              listaDivisa1.setSelectedIndex(selectedDivisa2Index);
              listaDivisa2.setSelectedIndex(selectedDivisa1Index);
              
              String savedResultadoLabel2 = resultadoLabel2.getText();
              
              double validationLabel = Double.parseDouble(savedResultadoLabel2);
              if (validationLabel != 0){
                 String savedValorIngresado = valor.getText();
                 
                 resultadoLabel2.setText(savedValorIngresado);
                 valor.setText(savedResultadoLabel2);
              }
        }); //Evento de intercambio
                  
          botton2.addActionListener((ActionEvent e) -> {
              String selectedDivisa1Index = (String) listaDivisa1.getSelectedItem();
              String selectedDivisa2Index = (String) listaDivisa2.getSelectedItem();
              

              // Realizar la conversión y asignar el resultado al JLabel de resultados
              Conversion valoresFinales = new Conversion(); // OJO - Implementa la lógica de conversión
              String valorExchange1 = valoresFinales.valorExchange (selectedDivisa1Index, selectedDivisa2Index);
              resultadoLabel.setText(valorExchange1); // Actualizar el texto del JLabel
            
              try{
              valorIngresado = valor.getText();
              double valorIngresadoDouble = Double.parseDouble(valorIngresado);
              double cambio =  Double.parseDouble(valorExchange1);
              String resultado = valoresFinales.resultadoConversion(valorIngresadoDouble, cambio);
              resultadoLabel2.setText(resultado);
               } catch (NumberFormatException ex) {
            // Mostrar un mensaje de error en caso de que el valor ingresado no sea numérico
               JOptionPane.showMessageDialog(panel, "Ingresa un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
              
        });
                 
                       
        panel.add(botton1);
        panel.add(botton2);
    }
    
    public void colocarCajaValor (){
        valor = new JTextField ();
        valor.setBounds(115, 280, 250, 25);
        valor.setText("Ingresa el total a convertir...");
        valor.setHorizontalAlignment(SwingConstants.CENTER);
        valor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valor.getText().equals("Ingresa el total a convertir...")) {
                    valor.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valor.getText().isEmpty()) {
                    valor.setText("Ingresa el total a convertir...");
                }
            }
        });
        
        
        panel.add(valor);
    }
    
    public void colocarListasDesplegables (){
        String [] ISO = {"COP", "EUR", "USD", "JPY", "GBP", "KRW"};
        listaDivisa1 = new JComboBox(ISO);
        listaDivisa2 = new JComboBox(ISO);   
        
        panel.add(listaDivisa1);
        panel.add(listaDivisa2);
        
        listaDivisa1.setBounds(120, 220, 60, 40);
        listaDivisa2.setBounds(300, 220, 60, 40);

    }
    
    public void colocarResultado (){
        String resultado = ""; 
        resultadoPanel = new JPanel();
        resultadoLabel = new JLabel(resultado);
        resultadoPanel2 = new JPanel();
        resultadoLabel2 = new JLabel(resultado);
    
        
        resultadoPanel.setBounds(138, 320, 200, 30);
        resultadoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde azul para el JPanel
        resultadoPanel.setBackground(Color.WHITE);
        resultadoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Diseño centrado con espacio
                
        panel.add(resultadoPanel);
        resultadoPanel.add(resultadoLabel);
        
        String resultado1 = ""; 
        resultadoPanel2 = new JPanel();
        resultadoLabel2 = new JLabel(resultado);
    
        
        resultadoPanel2.setBounds(138, 360, 200, 30);
        resultadoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde azul para el JPanel
        resultadoPanel2.setBackground(Color.WHITE);
        resultadoPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Diseño centrado con espacio

        panel.add(resultadoPanel2);
        resultadoPanel2.add(resultadoLabel2);
    
        resultadoLabel.setVerticalAlignment(SwingConstants.CENTER);
        resultadoLabel2.setVerticalAlignment(SwingConstants.CENTER);
    }
}