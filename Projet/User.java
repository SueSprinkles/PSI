import java.lang.String;
import java.net.*;
import java.util.Scanner;
import java.net.InetAddress;
import java.util.Random;

public class User
{
  private String utilisateur; // techniquement c'est son nom/pseudo mais c'est pour être en accord avec la rfc
  private int token; // penser à ajouter # quand on le mentionne
  private InetAddress ip;
  private boolean connected; // je le mets pour l'instant, on verra plus tard si on le retire

  // constructeur
  public User(String u, InetAddress ip){
    utilisateur = u;
    Random r = new Random();
    token = r.nextInt();
    if (token < 0)
      token = -token;
    this.ip = ip;
    connected = true;
  }

  // getters

  public String getUtilisateur(){
    return this.utilisateur;
  }

  public int getToken(){
    return this.token;
  }

  public InetAddress getIp(){
    return this.ip;
  }

  public boolean getConnected(){
    return this.connected;
  }

  // is same user ?
  public boolean isSameUser(User u){
    return this.token == u.token;
  }

  // connection

  public void set_connect(){
    this.connected = true;
  }
  // deconnection
  public void set_disconnect()
  {
    this.connected = false;
  }

  public void setIp(InetAddress i)
  {
    ip = i;
  }

}
