package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 5001;
        try {
            Circulo circulo = new Circulo();
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            while (true) {
                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                Double inClient = in.readDouble();
                System.out.println("He recibido un radio de: " + inClient);
                circulo.setRadio(inClient);
                double area = circulo.areaCirculo();
                out.writeDouble(area);
                System.out.println("He calculado el area y es: " + area);
                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getCanonicalName()).log(Level.SEVERE, null, ex);
        }
    }
}