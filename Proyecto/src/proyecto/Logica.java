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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class Logica extends JPanel implements Runnable, KeyListener {

    private Image carro;
    private Thread hilo;
    private int x, y;
    private final int RETARDO = 5;

    public Logica() {
        setBackground(Color.GRAY);
        setDoubleBuffered(true);
        carro = new ImageIcon(this.getClass().getResource("/imagenes/carro.jpg")).getImage();
        x = 600;
        y = 200;
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
            if (y > 0 + 5) {
                y -= 10;
            }
            System.out.println("Presion� UP!");
        }
        if (key == KeyEvent.VK_DOWN) {
            if (y < 500 - 130) {
                y += 10;
            }
            System.out.println("Presion� DOWN!");
        }
        if (key == KeyEvent.VK_LEFT) {
            if (x > 0 + 5) {
                x -= 10;
            }
            System.out.println("Presion� LEFT!");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (x < 500 - 130) {
                x += 10;
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
        g2.drawImage(carro, x, y, null);
        //Toolkit.getDefaultToolkit().sync();
        //g.dispose();
    }

    public void ciclo() {
        
    }

    @Override
    public void run() {
        while (true) {
            ciclo();
            repaint();
            try {
                Thread.sleep(RETARDO);
            } catch (InterruptedException err) {
                System.out.println(err);
            }
        }
    }
}
