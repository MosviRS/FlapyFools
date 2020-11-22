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
    public Flappy() {
        initComponents();
         
         
    }
    public void main(Circles cir,String data_clientes,Socket Cliente){
        krug.cir=cir;
        krug.Cliente=Cliente;
        krug.main(data_clientes);
        System.out.println(cir.getId()+" "+cir.getClintes());
        
        this.setSize(580, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        krug.setPreferredSize(getSize());
        krug.HEITH_WINDOWS_DOWN=this.getHeight();
        JPanel panel = new JPanel();          
        panel.add(krug);
        setContentPane(panel);//'panel' al estar dentro del rootpane es totalmente visible
        this.setVisible(true);
    
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
   public void comenzar(String bandera){
      
            if(bandera.equals("0")){
                anima= new Animacion(cliente);
                Thread anim = new Thread(anima);
                anim.start();
            }else{
                JOptionPane.showMessageDialog(null,"Waiting","Esperando a los demas jugadores",JOptionPane.INFORMATION_MESSAGE);
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
