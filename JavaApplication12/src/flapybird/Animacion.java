/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flapybird;

import clases.Circles;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Animacion extends Thread{

     
     int vreme = 0;
      //SOCKETS
     //Declaramos las variables necesarias para la conexion y comunicacion
    private Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;
    //El puerto debe ser el mismo en el que escucha el servidor
    private int puerto = 2027;
    //Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor
    private String host = "localhost";
    private boolean turno;
    private Circles cir;
    String recibido [];
    String datos;
     public  Animacion(Socket cliente){
          this.cliente=cliente;
          
          try {
            //Creamos el socket con el host y el puerto, declaramos los streams de comunicacion
            in = new DataInputStream(this.cliente.getInputStream());
            out = new DataOutputStream(this.cliente.getOutputStream());
           
            datos="0;0;0;1";
//            cri.setEsatdo(1);
          //  out.writeUTF(datos);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
     }
      public void enviarTurno(int f,int c){
        /*
        Comprobamos que sea nuestro turno para jugar, si no es devolmemos un mensaje
        Si es el turno entonces mandamos un mensaje al servidor con los datos de la jugada que hicimos
        */
        try {
            if(turno){
                String  datos = "";
                datos += f + ";";
                datos += c + ";";
                out.writeUTF(datos);
                out.flush();
                datos="";
            }
            else{
                //JOptionPane.showMessageDialog(this, "Esperando Jugadores");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
     public void run() {
         
        Flappy.krug.repaint();
    	for (int i = 0; i < 3; i++)
    	{
    		
    		Flappy.krug.dodajVreme(1000);
    		Flappy.krug.repaint();
    		sleep(1000);
           Flappy.krug.repaint();
    	}
    	Flappy.krug.dodajVreme(1000);
        while (true)
        {   
            
//            try{
//                datos=in.readUTF();
//                recibido=datos.split(";");
//                if(Integer.valueOf(recibido[3])==1){
//                    System.out.println("esperando");
//                }else{
//                    Flappy.krug.repaint();
//                    this.sleep(20);
//                }
//               
//            }catch(Exception e){
//                e.printStackTrace();
//            }
                    Flappy.krug.repaint();
                    this.sleep(20);
        }
       
    }
   
    void sleep(int n)
    {
        try {
           
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Flapy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
