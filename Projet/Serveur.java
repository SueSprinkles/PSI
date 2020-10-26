import java.net.*;
import java.io.*;

public class Serveur{

  public static void main(String[] args){
    int port = 1027;
    ServerSocket serveur = null;
    try {
      serveur = new ServerSocket(port);
    } catch (IOException e) {
      System.err.println("Echec création socket");
    }
    int nbrConnections = 0;
    while(true){
      try {
        Socket connection = serveur.accept();
        //OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream( ));
        //out.write("Connecté:" +connection+"\r\n");
        System.out.println("connexion !");
        //BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
        //String str = "bonjour nouveau client";
        //bos.write(str.getBytes());
        //bos.flush();
        SocketRun connectRun = new SocketRun(connection);
        Thread t = new Thread(connectRun);
        t.start();
        //connection.close();
      } catch (IOException e) {
        System.err.println("Echec connection");
      }
    }
  }

}
