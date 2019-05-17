package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

by etor
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Logica extends JPanel implements Runnable, KeyListener {

    private Image carro, carro1, carro2, carro3, carro4, carro5, carro6, carro7, carro8, pista, arbusto, pregunta;
    private Thread hilo;
    private int xC, yC, xP, yP, yV, yQ, total = 0, tiempo = 120000, aux = 0, min, seg, aux2;
    double puntos = 0;
    private final int RETARDO = 5;
    private boolean mov = true;
    private final static Color verde = new Color(34, 177, 76);
    DecimalFormat dec = new DecimalFormat("#.0");
    public ArrayList<Pregunta> preguntas = new ArrayList();

    public Logica() {

        preguntas.add(new Pregunta("1", "ABCD", "A"));
        preguntas.add(new Pregunta("2", "ABCD", "B"));
        preguntas.add(new Pregunta("3", "ABCD", "C"));
        preguntas.add(new Pregunta("4", "ABCD", "D"));
        preguntas.add(new Pregunta("5", "ABCD", "C"));
        preguntas.add(new Pregunta("6", "ABCD", "D"));
        preguntas.add(new Pregunta("7", "ABCD", "B"));
        preguntas.add(new Pregunta("8", "ABCD", "A"));
        preguntas.add(new Pregunta("9", "ABCD", "B"));
        preguntas.add(new Pregunta("10", "ABCD", "D"));

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

        if (key == KeyEvent.VK_ENTER) {
            //System.out.println("Presion� Enter!");
        }
        if (key == KeyEvent.VK_SPACE) {
            //System.out.println("Presion� Espacio!");
        }

        if (key == KeyEvent.VK_UP) {
            if (yC > 0 + 5) {
                yC -= 10;
            }
            //System.out.println("Presion� UP!");
        }

        if (key == KeyEvent.VK_UP) {
            if (yC > 0 + 5) {
                yC -= 10;
            }
            //System.out.println("Presion� UP!");
        }

        if (key == KeyEvent.VK_DOWN) {
            if (yC < 560 - 130) {
                yC += 10;
            }
            //System.out.println("Presion� DOWN!");
        }
        if (key == KeyEvent.VK_LEFT) {
            if (xC > 260 + 5) {
                xC -= 10;
            }
            //System.out.println("Presion� LEFT!");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (xC < 610 - 125) {
                xC += 10;
            }
            //System.out.println("Presion� RIGHT!");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Solt� la tecla =" + KeyEvent.getKeyText(e.getKeyCode()));
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
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 200, yV - 3365, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 250, yV - 4965, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 70, yV - 7465, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 20, yV - 8065, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 40, yV - 9964, 30, 1))) {
            return true;
        } else if (new Rectangle(xC, yC, 50, 1).intersects(new Rectangle(xP + 250, yV - 10965, 30, 1))) {
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
        g2.drawImage(arbusto, xP - 200, yV - 40, null);
        g2.drawImage(arbusto, xP + 300, yV - 200, null);
        g2.drawImage(arbusto, xP - 200, yV - 800, null);
        g2.drawImage(arbusto, xP - 100, yV - 650, null);
        g2.drawImage(arbusto, xP - 180, yV - 230, null);
        g2.drawImage(arbusto, xP + 350, yV - 400, null);
        g2.drawImage(arbusto, xP + 300, yV - 1000, null);
        g2.drawImage(arbusto, xP + 400, yV - 750, null);

        g2.drawImage(pregunta, xP + 90, yV - 400, null);
        g2.drawImage(pregunta, xP + 120, yV - 1000, null);
        g2.drawImage(pregunta, xP + 50, yV - 2000, null);
        g2.drawImage(pregunta, xP + 200, yV - 3400, null);
        g2.drawImage(pregunta, xP + 250, yV - 5000, null);
        g2.drawImage(pregunta, xP + 70, yV - 7500, null);
        g2.drawImage(pregunta, xP + 20, yV - 8100, null);
        g2.drawImage(pregunta, xP + 40, yV - 9999, null);
        g2.drawImage(pregunta, xP + 250, yV - 11000, null);
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
            try {
                Thread.sleep(RETARDO);
                puntuacion(0.1);
                System.out.println("puntos" + dec.format(puntos) + " " + tiempo(5));
                if (min <= 0 && seg <= 0) {
                    JOptionPane.showMessageDialog(null, "Fin del juego!");
                    Thread.sleep(1500);
                    System.exit(0);
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

    public boolean choque(int index) {
        try {
            JOptionPane.showMessageDialog(null, "Chocaste: -10 segundos");
            tiempo -= 10000;
            return true;
        } catch (Exception e) {
        }
        return true;
    }

    public boolean pregunta(int index) {
        try {
            String preg = JOptionPane.showInputDialog(preguntas.get(index).getPregunta());
            if (preg.equals(preguntas.get(index).getRespuesta())) {
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

    public double puntuacion(double i) {
        puntos += i;
        return puntos;
    }

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
