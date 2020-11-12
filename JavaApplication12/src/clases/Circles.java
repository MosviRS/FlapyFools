/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Circles extends Clase_Cliente {
    public int pos_X,pos_Y;
     int radius = 30;
     public  Circles(int x, int y){
         this.pos_X=x;
         this.pos_Y=y;
     }
     public Circles(){
         
     }
      public void DrawShapes(Graphics g,Color topkaBoja,Rectangle topkas){
          this.pos_Y=topkas.y;
          //this.pos_X=topkas.x;
        g.setColor(topkaBoja);
        g.fillOval(pos_X, topkas.y, radius, radius);
        g.setColor(Color.black);
        g.drawOval(pos_X,topkas.y, radius, radius);
  
    }
}
