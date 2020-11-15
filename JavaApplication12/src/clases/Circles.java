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

    /**
     * @return the col
     */
    public Color getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(Color col) {
        this.col = col;
    }

    /**
     * @return the pos_X
     */
    public int getPos_X() {
        return pos_X;
    }

    /**
     * @param pos_X the pos_X to set
     */
    public void setPos_X(int pos_X) {
        this.pos_X = pos_X;
    }

    /**
     * @return the pos_Y
     */
    public int getPos_Y() {
        return pos_Y;
    }

    /**
     * @param pos_Y the pos_Y to set
     */
    public void setPos_Y(int pos_Y) {
        this.pos_Y = pos_Y;
    }
    private int pos_X;
    private int pos_Y;
    int radius = 30;
    private Color col;
     public  Circles(int x, int y){
         this.pos_X=x;
         this.pos_Y=y;
     }
     public Circles(){
         
     }
      public void DrawShapes(Graphics g,Color topkaBoja,Rectangle topkas){
          this.setPos_Y(topkas.y);
          this.setPos_X(topkas.x);
          //this.pos_X=topkas.x;
        g.setColor(this.col);
        g.fillOval(topkas.x, topkas.y, radius, radius);
        g.setColor(Color.black);
        g.drawOval(topkas.x,topkas.y, radius, radius);
  
    }
}
