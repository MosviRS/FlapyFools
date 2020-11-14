package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor {
    //Inicializamos el puerto
    private final int puerto = 2027;
    //Numero maximo de conexiones (el tictactoe es un juego para 2)
    private final int noConexiones = 2;
    //Creamos una lista de sockets para guardar el socket de cada jugador
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    //Variable para controlar el turno de cada jugador
    private Boolean turno = true;
    //Matriz donde se guardan los movimientos 

    //Numero de veces que se juega...para controlar las X y O
    private int turnos = 1;
    int idCliente=0;
     Socket cliente;
     private DataOutputStream out;
    private DataInputStream in;
   //Funcion para que el servidor empieze a recibir conexiones de clientes
    public void escuchar(){
        String datos="";
        try {
            //Inicializamos la matriz del juego con -1

            //Creamos el socket servidor
            ServerSocket servidor = new ServerSocket(puerto,noConexiones);
            //Ciclo infinito para estar escuchando por nuevos jugadores
            System.out.println("Esperando jugadores....");
            while(usuarios.size()<2){
                    //Cuando un jugador se conecte guardamos el socket en nuestra lista
                     cliente = servidor.accept();
                    //Se agrega el socket a la lista
                     in = new DataInputStream(this.cliente.getInputStream());
                     out = new DataOutputStream(this.cliente.getOutputStream());
                     String data=in.readUTF();
                     
                    System.out.println(cliente.getInetAddress()+ " "+servidor.getInetAddress());
                    usuarios.add(cliente);
                    //Se le genera un turno X o O 
                     String recibido []=data.split(";");
                     recibido[0]=String.valueOf(usuarios.size()-1);
                     datos=datos+convertir(recibido)+"|";
                    System.out.println("cehnel "+servidor.getChannel());
                  
            }
            System.out.println("Se coencto");
            System.out.println(datos);
            for (int i = 0; i < usuarios.size(); i++) {
                    int xo = turnos % 2 == 0 ? 1 : 0;
                    turnos++;
                    enviarclientes(usuarios.get(i),datos);
                    
            }
            for (int i = 0; i < usuarios.size(); i++) {
                    int xo = turnos % 2 == 0 ? 1 : 0;
                    turnos++;
                    //Instanciamos un hilo que estara atendiendo al cliente y lo ponemos a escuchar
                    confirmacion(usuarios.get(i),i,usuarios.size());
                    Runnable  run = new HiloServidor(usuarios.get(i),usuarios,xo);
                    Thread hilo = new Thread(run);
                    hilo.start();

            }
            
//            while(true){
//                    int xo = turnos % 2 == 0 ? 1 : 0;
//                    turnos++;
//                    //Instanciamos un hilo que estara atendiendo al cliente y lo ponemos a escuchar
//                    Runnable  run = new HiloServidor(cliente,usuarios,xo);
//                    Thread hilo = new Thread(run);
//                    hilo.start();
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmacion(Socket cli,int id_jugador, int noJugadores){
        try{
            in = new DataInputStream(cli.getInputStream());
            out = new DataOutputStream(cli.getOutputStream());
            out.writeUTF(String.valueOf(id_jugador)+";"+noJugadores+";0;0");
        }catch(Exception e){
            System.out.println("no s eudo mandar ka condirmacion");
        }
    }
    public void enviarclientes(Socket cli,String datos){
         try{
            in = new DataInputStream(cli.getInputStream());
            out = new DataOutputStream(cli.getOutputStream());
            out.writeUTF(datos);
        }catch(Exception e){
            System.out.println("no s eudo mandar ka condirmacion");
        }
    }
    public String convertir(String [] vec){
        String cadena="";
        for (int i = 0; i < vec.length; i++) {
            cadena=cadena+vec[i]+";";
        }
        return cadena;
    }
    //Funcion main para correr el servidor
    public static void main(String[] args) {
        Servidor servidor= new Servidor();
        servidor.escuchar();
    }
}
