package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logica extends JPanel implements Runnable, KeyListener {

    private Image carro, pista, arbusto, pregunta;
    private Thread hilo;
    private int xC, yC, xP, yP, yV, yQ;
    private final int RETARDO = 5;
    private boolean mov = true;
    private final static Color verde = new Color(34, 177, 76);

    public Logica() {
        setBackground(verde);
        setDoubleBuffered(true);
        pista = new ImageIcon(this.getClass().getResource("/imagenes/pista.jpg")).getImage();
        carro = new ImageIcon(this.getClass().getResource("/imagenes/carro.jpg")).getImage();
        arbusto = new ImageIcon(this.getClass().getResource("/imagenes/arbusto.jpg")).getImage();
        pregunta = new ImageIcon(this.getClass().getResource("/imagenes/pregunta.jpg")).getImage();
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
            System.out.println("Presion� Enter!");
        }
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("Presion� Espacio!");
        }

        if (key == KeyEvent.VK_UP) {
            if (yC > 0 + 5) {
                yC -= 10;
            }
            System.out.println("Presion� UP!");
        }

        if (key == KeyEvent.VK_UP) {
            if (yC > 0 + 5) {
                yC -= 10;
            }
            System.out.println("Presion� UP!");
        }

        if (key == KeyEvent.VK_DOWN) {
            if (yC < 560 - 130) {
                yC += 10;
            }
            System.out.println("Presion� DOWN!");
        }
        if (key == KeyEvent.VK_LEFT) {
            if (xC > 260 + 5) {
                xC -= 10;
            }
            System.out.println("Presion� LEFT!");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (xC < 610 - 125) {
                xC += 10;
            }
            System.out.println("Presion� RIGHT!");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Solt� la tecla =" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Oprimi� la tecla =" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
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
        g2.drawImage(pregunta, xP + 90, yV+200, null);
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
        yV += 2;
        if (yV > (1200)) {
            yV = -330;
        }
    }

    public void cicloQ() {
        yQ += 1;
        if (yQ > (900)) {
            yQ = -150;
        }
    }

    @Override
    public void run() {
        while (true) {
            ciclo();
            cicloP();
            repaint();
            /*NO FUNCIONA (metodos no compatibles)if (carro.getGraphics().getClipBounds().intersects(pregunta.getGraphics().getClipBounds())) {
                JOptionPane.showInternalMessageDialog(this, "AQUI VA LA PREGUNTA");
            }*/
            try {
                Thread.sleep(RETARDO);
            } catch (InterruptedException err) {
                System.out.println(err);
            }
        }
    }
}
