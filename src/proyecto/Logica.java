package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Logica extends JPanel implements Runnable, KeyListener, LogicaI {
    private Image carro, carro1, carro2, carro3, carro4, carro5, carro6, carro7, carro8, pista, arbusto, pregunta;
    private Thread hilo;
    private int xC, yC, xP, yP, yV, yQ, total = 0, tiempo = 120000, tiempo2 = 120000, aux = 0, min, seg, aux2;
    double puntos = 0;
    private final int RETARDO = 5;
    private boolean mov = true;
    private final static Color verde = new Color(34, 177, 76);
    DecimalFormat dec = new DecimalFormat("#.0");
    public ArrayList<Pregunta> preguntas = new ArrayList();
    Calendar calendario;
    Thread h1;

    public Logica() {

        preguntas.add(new Pregunta("Cuantas flores hay en dos docenas de rosas?", "\na.24\nb.32\nc.6\nd.12", "a"));
        preguntas.add(new Pregunta("Por cuanto tenemos que multiplicar el 6 para obtener 36?", "\na.4\nb.6\nc.8\nd.3", "b"));
        preguntas.add(new Pregunta("Cual es el resultado de 3.15*100?", "\na.3150\nb.31.50\nc.315\nd.0.315", "c"));
        preguntas.add(new Pregunta("Que es mas ligero?", "\na.100 gramos de hierro\nb.1 kilo de algodon\nc.1 kilo de plumas\nd.1 kilo de lana", "a"));
        preguntas.add(new Pregunta("Un triangulo equilatero tiene?", "\na.1 angulo recto\nb.los 3 lados diferentes\nc.2 lados iguales\nd.los 3 lados iguales", "d"));
        preguntas.add(new Pregunta("Que distancia recorrera un coche en 3 horas si va a 50 km/h", "\na.500 km\nb.150 km\nc.100 km\nd.300 km", "b"));
        preguntas.add(new Pregunta("Si el radio de un circulo mide 10 cm cuanto mide su diametro", "\na.50 cm\nb.1 metro\nc.20 cm\nd.30 cm", "c"));
        preguntas.add(new Pregunta("Juan tiene 10 años, Pepe tiene 5 mas que Juan, y Andres tiene 3 menos que Juan, cuantos años tiene Andres?", "\na.15 años\nb.7 años\nc.13 años\nd.5 años", "b"));
        preguntas.add(new Pregunta("Cual es el resultado de sumar 1 hora y 40 minutros y 1 hora y 30 minutos?", "\na.2 horas y 50 minutos\nb.1 hora y 120 minutos\nc.3 horas y 10 minutos\nd.2 horas y 70 minutos", "c"));
        preguntas.add(new Pregunta("Una caja tiene 6 galletas, si compramos 4 cajas y media, cuantas galletas tenemos?", "\na.24\nb.27\nc.30\nd.26", "b"));
        preguntas.add(new Pregunta("Un hombre tiene 18 rosas, las reparte en partes iguales en 3 jarrones, Cuantas rosas debe colocar en cada jarron?", "\na.15\nb.9\nc.4\nd.6", "d"));
        preguntas.add(new Pregunta("Que numero es el ocho mil uno?", "\na.1800\nb.1801\nc.1008\nd.8001", "b"));
        preguntas.add(new Pregunta("Cuantos lados tiene un hexagono?", "\na.7 lados\nb.6 lados\nc.8 lados\nd.5 lados", "b"));
        preguntas.add(new Pregunta("De los 50 animales de una granja, 20 son corderos, el granjero a realizado grupos de 5 corderos, cuantos grupos a realizado si 10 corderos son cojos?", "\na.5 grupos de corderos cojos\nb.4 grupos\nc.5 grupos\nd.10 grupos de corderos", "b"));
        preguntas.add(new Pregunta("Cuantos centimetros son 8 metros?", "\na.80\nb.800\nc.8000\nd.0.8", "b"));
        preguntas.add(new Pregunta("Cuantos metros son 15000 milimetros?", "\na.1500\nb.150\nc.1.5\nd.15", "d"));
        preguntas.add(new Pregunta("Cuantos decimetros son 26 decametros?", "\na.2600\nb.26000\nc.260\nd.26", "c"));
        preguntas.add(new Pregunta("Cuantos metros son 10 km?", "\na.300\nb.30\nc.3000\nd.303", "c"));
        preguntas.add(new Pregunta("Que fraccion es equibalente a 12/18?", "\na.6/9\nb.12/9\nc.6/18\nd.18/12", "a"));
        preguntas.add(new Pregunta("Que fraccion es once novenos?", "\na.9/11\nb.1/9\nc.11/9\nd.11/19", "c"));

        setBackground(verde);
        setDoubleBuffered(true);

        pista = new ImageIcon(this.getClass().getResource("/imagenes/pista.jpg")).getImage();
        carro = new ImageIcon(this.getClass().getResource("/imagenes/carro.jpg")).getImage();
        arbusto = new ImageIcon(this.getClass().getResource("/imagenes/arbusto.jpg")).getImage();
        pregunta = new ImageIcon(this.getClass().getResource("/imagenes/pregunta.jpg")).getImage();
        carro1 = new ImageIcon(this.getClass().getResource("/imagenes/auto1.jpg")).getImage();
        carro2 = new ImageIcon(this.getClass().getResource("/imagenes/auto2.jpg")).getImage();
        carro3 = new ImageIcon(this.getClass().getResource("/imagenes/auto3.jpg")).getImage();
        carro4 = new ImageIcon(this.getClass().getResource("/imagenes/auto4.jpg")).getImage();
        carro5 = new ImageIcon(this.getClass().getResource("/imagenes/auto5.jpg")).getImage();
        carro6 = new ImageIcon(this.getClass().getResource("/imagenes/auto6.jpg")).getImage();
        carro7 = new ImageIcon(this.getClass().getResource("/imagenes/auto7.jpg")).getImage();
        carro8 = new ImageIcon(this.getClass().getResource("/imagenes/auto8.jpg")).getImage();
        xC = 375;
        yC = 400;
        xP = 250;
        yP = 0;
        yQ = 0;
        addKeyListener(this);
        setFocusable(true);

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (xC > 260 + 5) {
                carro = new ImageIcon(this.getClass().getResource("/imagenes/carroI.jpg")).getImage();
                xC -= 10;
            }
            //System.out.println("Presion� LEFT!");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (xC < 610 - 125) {
                carro = new ImageIcon(this.getClass().getResource("/imagenes/carroD.jpg")).getImage();
                xC += 10;
            }
            //System.out.println("Presion� RIGHT!");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            carro = new ImageIcon(this.getClass().getResource("/imagenes/carro.jpg")).getImage();
        }
        if (key == KeyEvent.VK_RIGHT) {
            carro = new ImageIcon(this.getClass().getResource("/imagenes/carro.jpg")).getImage();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Oprimi� la tecla =" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }

    public boolean colisionP() {
        if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 365, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 965, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 50, yV - 1965, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 100, yV - 3365, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 250, yV - 4965, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 7465, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 20, yV - 8065, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 40, yV - 9964, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 10965, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 12365, 30, 1))) {
            return true;
        }
        return false;
    }

    public boolean colisionC() {
        if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV + 10, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 590, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 84, yV - 1200, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 56, yV - 1600, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 1600, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 1900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 2300, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 2500, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 2800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 3200, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 3800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 74, yV - 3800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 4100, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 4500, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 4900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 156, yV - 5000, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 220, yV - 5300, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 98, yV - 5800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 220, yV - 6100, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 56, yV - 6400, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 6900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 7500, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 7900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 8300, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 8900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 90, yV - 9400, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 9800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 10000, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 10400, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 10900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 74, yV - 11500, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 11900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 12500, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 12900, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 84, yV - 13300, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 56, yV - 13800, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 180, yV - 14200, 54, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 120, yV - 14400, 54, 1))) {
            return true;
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(pista, xP, yP, null);
        g2.drawImage(carro, xC, yC, null);
        g2.drawImage(arbusto, xP + 350, yV - 400, null);
        g2.drawImage(arbusto, xP - 200, yV - 1000, null);
        g2.drawImage(arbusto, xP + 300, yV - 2000, null);
        g2.drawImage(arbusto, xP - 180, yV - 3000, null);
        g2.drawImage(arbusto, xP + 380, yV - 4000, null);
        g2.drawImage(arbusto, xP - 180, yV - 5000, null);
        g2.drawImage(arbusto, xP + 350, yV - 6000, null);
        g2.drawImage(arbusto, xP - 150, yV - 7000, null);
        g2.drawImage(arbusto, xP + 360, yV - 8000, null);
        g2.drawImage(arbusto, xP + 300, yV - 10000, null);
        g2.drawImage(arbusto, xP - 180, yV - 11000, null);
        g2.drawImage(arbusto, xP + 380, yV - 12000, null);
        g2.drawImage(arbusto, xP - 180, yV - 13000, null);
        g2.drawImage(arbusto, xP + 350, yV - 14000, null);

        g2.drawImage(pregunta, xP + 90, yV - 400, null);
        g2.drawImage(pregunta, xP + 120, yV - 1000, null);
        g2.drawImage(pregunta, xP + 50, yV - 2000, null);
        g2.drawImage(pregunta, xP + 100, yV - 3400, null);
        g2.drawImage(pregunta, xP + 250, yV - 5000, null);
        g2.drawImage(pregunta, xP + 70, yV - 7500, null);
        g2.drawImage(pregunta, xP + 20, yV - 8100, null);
        g2.drawImage(pregunta, xP + 40, yV - 9999, null);
        g2.drawImage(pregunta, xP + 120, yV - 11000, null);
        g2.drawImage(pregunta, xP + 90, yV - 12400, null);

        g2.drawImage(carro1, xP + 200, yV - 100, null);
        g2.drawImage(carro6, xP + 70, yV - 690, null);
        g2.drawImage(carro3, xP + 200, yV - 900, null);
        g2.drawImage(carro4, xP + 84, yV - 1300, null);
        g2.drawImage(carro1, xP + 56, yV - 1700, null);
        g2.drawImage(carro5, xP + 180, yV - 1700, null);
        g2.drawImage(carro6, xP + 120, yV - 2000, null);
        g2.drawImage(carro8, xP + 90, yV - 2400, null);
        g2.drawImage(carro1, xP + 200, yV - 2600, null);
        g2.drawImage(carro2, xP + 70, yV - 2900, null);
        g2.drawImage(carro7, xP + 180, yV - 3300, null);
        g2.drawImage(carro4, xP + 200, yV - 3900, null);
        g2.drawImage(carro1, xP + 74, yV - 3900, null);
        g2.drawImage(carro8, xP + 90, yV - 4200, null);
        g2.drawImage(carro1, xP + 200, yV - 4600, null);
        g2.drawImage(carro2, xP + 70, yV - 5000, null);
        g2.drawImage(carro5, xP + 156, yV - 5100, null);
        g2.drawImage(carro8, xP + 220, yV - 5400, null);
        g2.drawImage(carro6, xP + 98, yV - 5900, null);
        g2.drawImage(carro4, xP + 220, yV - 6200, null);
        g2.drawImage(carro1, xP + 56, yV - 6500, null);
        g2.drawImage(carro5, xP + 180, yV - 7000, null);
        g2.drawImage(carro6, xP + 120, yV - 7600, null);
        g2.drawImage(carro8, xP + 90, yV - 8000, null);
        g2.drawImage(carro5, xP + 180, yV - 8400, null);
        g2.drawImage(carro6, xP + 120, yV - 9000, null);
        g2.drawImage(carro8, xP + 90, yV - 9500, null);
        g2.drawImage(carro1, xP + 200, yV - 9900, null);
        g2.drawImage(carro2, xP + 70, yV - 10100, null);
        g2.drawImage(carro7, xP + 180, yV - 10500, null);
        g2.drawImage(carro4, xP + 200, yV - 11000, null);
        g2.drawImage(carro1, xP + 74, yV - 11600, null);
        g2.drawImage(carro1, xP + 200, yV - 12000, null);
        g2.drawImage(carro6, xP + 70, yV - 12600, null);
        g2.drawImage(carro3, xP + 200, yV - 13000, null);
        g2.drawImage(carro4, xP + 84, yV - 13400, null);
        g2.drawImage(carro1, xP + 56, yV - 13900, null);
        g2.drawImage(carro5, xP + 180, yV - 14300, null);
        g2.drawImage(carro6, xP + 120, yV - 14500, null);
        g2.drawString("Puntos: " + dec.format(puntos), 50, 50);
        g2.drawString(tiempo(0), 50, 70);
        //Toolkit.getDefaultToolkit().sync();
        //g.dispose();
    }

    public void ciclo() {
        yP += 1;
        if (yP > (0)) {
            yP = -150;
        }
    }

    public void cicloP() {
        yV += 1;
        if (yV > (15000)) {
            yV = -50;
        }
    }
    
    @Override
    public void run() {
        int index = 0;
        while (true) {
            ciclo();
            cicloP();
            repaint();
            //   run2();
            try {
                Thread.sleep(RETARDO);
                puntuacion(0.1);
                tiempo(5);

                //System.out.println("puntos" + dec.format(puntos) + " " + tiempo(5));
                if (min <= 0 && seg <= 0) {

                    File archivo;
                    FileWriter escribir;
                    PrintWriter linea;
                    String nom = "", eq = "";
                    String fecha;
                    Thread ct = Thread.currentThread();
                    Calendar calendar = Calendar.getInstance();
                    String[] dias = {"", "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
                    String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                    fecha = ((dias[(calendar.get(7))] + " - " + (calendar.get(5)) + " de " + meses[(calendar.get(2) + 1)] + " del " + (calendar.get(1)) + " ,"));
                    archivo = new File("Base_de_Datos.txt");
                    if (!archivo.exists()) {
                        try {
                            archivo.createNewFile();
                            nom = JOptionPane.showInputDialog(null, "Nombre", " Nombre del Usuario");

                            eq = JOptionPane.showInputDialog(null, "Equipo", " Nombre del Equipo");

                            escribir = new FileWriter(archivo, true);
                            linea = new PrintWriter(escribir);
                            linea.println("Nombre: " + nom);
                            linea.println("Equipo: " + eq);
                            linea.println("Puntos: " + puntos);
                            linea.println("Fecha: " + fecha);
                            linea.close();
                            escribir.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            nom = JOptionPane.showInputDialog(null, "Nombre", " Nombre del Usuario");

                            eq = JOptionPane.showInputDialog(null, "Equipo", " Nombre del Equipo");

                            escribir = new FileWriter(archivo, true);
                            linea = new PrintWriter(escribir);
                            linea.println("-------------------------");
                            linea.println("-------------------------");
                            linea.println("Nombre: " + nom);
                            linea.println("Equipo: " + eq);
                            linea.println("Puntos: " + puntos);
                            linea.println("Fecha: " + fecha);
                            linea.close();
                            escribir.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    JOptionPane.showMessageDialog(null, "Fin del juego!");
           
     
          
                }
            } catch (InterruptedException err) {
                System.out.println(err);
            }
             
            try {
                if (colisionP()) {
                    boolean validador = pregunta(index);
                    index++;
                    while (validador == false) {
                        Thread.sleep(1);
                        pregunta(index);
                        index++;
                    }
                } else if (colisionC()) {
                    boolean validadorC = choque(index);
                    while (validadorC == false) {
                        JOptionPane.showMessageDialog(null, "chocaste");
                    }
                }
            } catch (InterruptedException err) {
                System.out.println(err);
            }
            
        }
        }

         
    @Override
    public void guardar() {
        String dato; //variable para almacenar nombre y apellido
        String cadena; //nombre;apellido
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo

        try {

            fichero = new FileWriter("f:/ejemplo.txt", true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite nombre:");
            dato = br.readLine();
            cadena = dato + ";";
            System.out.println("Digite apellido:");
            dato = br.readLine();
            cadena = cadena + dato + ";";

            linea.println(cadena); //escribiendo en el archivo

        } catch (IOException e) {
            System.out.print("Error creando archivo");
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
    }

    @Override
    public boolean choque(int index) {
        try {
            JOptionPane.showMessageDialog(null, "Chocaste: -10 segundos");
            tiempo -= 10000;
            return true;
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public boolean pregunta(int index) {
        try {
            String preg = JOptionPane.showInputDialog(preguntas.get(index).getPregunta() + preguntas.get(index).getOpcionesR());
            if (preg.equalsIgnoreCase(preguntas.get(index).getRespuesta())) {
                System.out.println("puntos" + dec.format(puntuacion(100)));
                tiempo += 3000;
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error!");
                tiempo -= 5000;
                return true;
            }
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public double puntuacion(double i) {
        puntos += i;
        return puntos;
    }

    @Override
    public String tiempo(int i) {
        String cad = "Tiempo: ";
        aux += i;
        if (aux == 1000) {
            aux = 0;
            tiempo -= 1000;
        }
        seg = tiempo / 1000;
        aux2 = seg % 60;
        min = (seg - aux2) / 60;
        seg = aux2;
        //cad += (tiempo/1000);
        if (seg < 10) {
            cad += ("0" + min + ":" + "0" + seg);
        } else {
            cad += ("0" + min + ":" + seg);
        }
        return cad;
    }

}
