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

    private Image carro, fondo;
    private Thread hilo;
    private int x, y;
    private final int RETARDO = 15;

    public Logica() {
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        fondo = new ImageIcon(this.getClass().getResource("/imagenes/asfalto.jpg")).getImage();
        carro = new ImageIcon(this.getClass().getResource("/imagenes/carro2v.png")).getImage();
        x = 350;
        y = 220;
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

        if (key == KeyEvent.VK_DOWN) {
            if (y < 700 - 130) {
                y += 10;
                carro = new ImageIcon(this.getClass().getResource("/imagenes/carro2v.png")).getImage();
            }
            System.out.println("Presion� DOWN!");
        }
        if (key == KeyEvent.VK_LEFT) {
            if (x > 0 + 5) {
                x -= 10;
                carro = new ImageIcon(this.getClass().getResource("/imagenes/carro2I.png")).getImage();
            }
            System.out.println("Presion� LEFT!");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (x < 830 - 130) {
                x += 10;
                carro = new ImageIcon(this.getClass().getResource("/imagenes/carro2D.png")).getImage();
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
        g2.drawImage(fondo, 50, 0, null);
        g2.drawImage(carro, x, y, null);
        
        //Toolkit.getDefaultToolkit().sync();
        //g.dispose();
    }

    public void ciclo() {
        y += 1;
        if (y > (500 + 70)) {
            y = +70;
        }
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
