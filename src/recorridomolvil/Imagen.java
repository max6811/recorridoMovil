/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridomolvil;

/**
 *
 * @author Max
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagen extends javax.swing.JPanel implements Runnable{
    int x, y,i1,j1;
    Thread hilo;
    JPanel jpanel;
    public Imagen(JPanel jPanel1) {
        jpanel = jPanel1;
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
        hilo = new Thread(this,"hilo1");
        j1 = 0;
        i1 = 0;
        hilo.start();
    }

   // @Override
    public void paint(Graphics g,int i,int j) {
        ImageIcon Img = new ImageIcon(getClass().getResource("/imageMovil/MAPA.png"));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
        g.setColor(Color.yellow);
        g.drawOval(50, 50, 100, 100);
        g.drawImage(new ImageIcon(getClass().getResource("/imageMovil/01.png")).getImage(),i,j,55,62,null);
        //hilo.start();
      } 

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            paint(jpanel.getGraphics(),i1+2,j1+2);
           // this.repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void paintF(Graphics g,int x, int y){
        g.drawImage(new ImageIcon(getClass().getResource("/imageMovil/11.png")).getImage(),200,200,55,62,null);
        
    }
    
   
}
