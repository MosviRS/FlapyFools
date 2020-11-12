
package Sockets;

import clases.Circles;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author netosolis
 */
public class HiloServidor implements Runnable{
    //Declaramos las variables que utiliza el hilo para estar recibiendo y mandando mensajes
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    //Varible para guardar que le toco al jugador X o O
    private int XO;
    //Matriz del juego
    private int G[][];
    //Turno
    private boolean turno;
    //Lista de los usuarios conectados al servidor
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    int idCliente=0;
    Circles cir;
     String recibido [];
    //Constructor que recibe el socket que atendera el hilo y la lista de los jugadores el turno y la matriz del juego
    public HiloServidor(Socket soc,LinkedList users,int xo){
        socket = soc;
        usuarios = users;
        XO = xo;
    
    }
    
    
    @Override
    public void run() {
        try {
            //Inicializamos los canales de comunicacion y mandamos el turno a cada jugador
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            turno = XO == 1;
            
        
            
            //Ciclo infinito que estara escuchando por los movimientos de cada jugador
            //Cada que un jugador pone una X o O viene aca y le dice al otro jugador que es su turno
            System.out.println("jdnhd");
           while(true){
               String cad="";
                String rec=in.readUTF();
                recibido =rec.split(";");
                idCliente=idCliente+Integer.valueOf(recibido[3]);
                System.out.println("jdjd "+recibido[3]);
//               
//               if(idCliente==1){
//                   recibido[3]="0";
//                    
//                    cad += recibido[0]+";";
//                    cad += recibido[1]+";";
//                    cad += recibido[2]+";";
//                    cad += recibido[3]+";";
//                   out.writeUTF(cad);
//               }else{
//                   
//                    cad += recibido[0]+";";
//                    cad += recibido[1]+";";
//                    cad += recibido[2]+";";
//                    cad += recibido[3]+";";
//                    out.writeUTF(cad);
//                   System.out.println("aun no estan tofodso");
//               }
//                
//                
//                for (Socket usuario : usuarios) {
//                    out = new DataOutputStream(usuario.getOutputStream());
//                    out.writeUTF(cad);
//                }
          }
        } catch (Exception e) {
            
            //Si ocurre un excepcion lo mas seguro es que sea por que algun jugador se desconecto asi que lo quitamos de la lista de conectados
            for (int i = 0; i < usuarios.size(); i++) {
                if(usuarios.get(i) == socket){
                    usuarios.remove(i);
                    break;
                } 
            }
         
        }
    }
    
    //Funcion comprueba si algun jugador ha ganado el juego
    public boolean gano(int n){
        for (int i = 0; i < 3; i++) {
            boolean gano = true;
            for (int j = 0; j < 3; j++) {
                 gano = gano && (G[i][j] == n); 
            }
            if(gano){
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            boolean gano = true;
            for (int j = 0; j < 3; j++) {
                 gano = gano && (G[j][i] == n); 
            }
            if(gano){
                return true;
            }
        }
        
        if(G[0][0] == n && G[1][1] == n && G[2][2] == n)return true;
        
        return false;
    }
    
 
    
  
}
