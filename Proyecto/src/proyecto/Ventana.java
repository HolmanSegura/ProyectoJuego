package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Ventana extends JFrame {

    public Ventana() {
        setTitle("Proyecto juego");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new Logica());
        setVisible(true);
    }

    //METODO PRINCIPAL - SERA BUSCADO AL EJECUTAR UN PROGRAMA EN JAVA
    public static void main(String args[]) {
        new Ventana();
    }
}
