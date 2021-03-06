/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flapybird;

import clases.Circles;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Flappy extends javax.swing.JFrame {

    /**
     * Creates new form Flappy
     */
    
    public static Topka krug= new Topka();
    public Animacion anima;
    public Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;
    Thread anim;
    boolean banmdera=false;
    public String id;
    
    public Flappy() {
        initComponents();
        this.setResizable(false);
         
    }
    public void main(Circles cir,String data_clientes,Socket Cliente){
        krug.cir=cir;
        krug.Cliente=Cliente;
        krug.main(data_clientes);
        System.out.println(cir.getId()+" "+cir.getClintes());
        id=cir.getId();
        this.setSize(580, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        krug.setPreferredSize(getSize());
        krug.HEITH_WINDOWS_DOWN=this.getHeight();
        JPanel panel = new JPanel();          
        panel.add(krug);
        setContentPane(panel);//'panel' al estar dentro del rootpane es totalmente visible
        this.setVisible(true);
        String [] datlen=data_clientes.split("\\|");
            
            if(Integer.parseInt(id)!=(datlen.length-1)){
                banmdera=true;
            }
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (anim.isAlive()) {
            anim.stop();
            
        }
        this.dispose();
        System.exit(0);
       
        
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
  public String [] recibir_data(){
       String [] separado=null;
       try{
            in = new DataInputStream(this.cliente.getInputStream());
            out = new DataOutputStream(this.cliente.getOutputStream());
            
            String data=in.readUTF();
            System.out.println(data);
            separado= data.split(";");
            
           
         } catch (Exception e) {
            e.printStackTrace();
        }
       return  separado;
  }
   public boolean comenzar(String bandera){
      
            if(bandera.equals("0")){
               if(banmdera){
                   try{
                   Thread.sleep(2000);
                   }catch(InterruptedException e){
                       System.out.println("Error "+ e.getStackTrace());
                   }
               }
              
                anima= new Animacion(cliente);
                anim = new Thread(anima);
                anim.start();
               
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Waiting","Esperando a los demas jugadores",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
    
   }
   public String Recibir_clietes(){
       String data=null;
     
       try{
            in = new DataInputStream(this.cliente.getInputStream());
            out = new DataOutputStream(this.cliente.getOutputStream());
            
            data=in.readUTF();
      
            System.out.println("datso "+data);
            
           
           
           
         } catch (Exception e) {
            data="no hay datois";
            e.printStackTrace();
        }
        return data;
       
   }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Flappy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flappy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flappy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flappy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flappy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
