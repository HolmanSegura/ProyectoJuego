package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    public Ventana() {

        setTitle("Proyecto juego");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
       
        setLocationRelativeTo(null);
        setResizable(false);
        add(new Logica());
        setUndecorated(true);
        setVisible(true);
       
           }
    
}