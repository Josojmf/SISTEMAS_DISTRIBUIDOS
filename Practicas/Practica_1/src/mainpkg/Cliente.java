package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5001;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el radio de su circulo");
        double input = scanner.nextDouble();
        scanner.close();
        try {
        	Circulo circulo = new Circulo();
        	circulo.setRadio(input);
            double radio = circulo.getRadio();
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeDouble(radio);
            double recv = in.readDouble();
            String output = "El area calculada del circulo es: " + recv;
            System.out.println(output);
            sc.close();
        } catch (

        IOException ex) {
            Logger.getLogger(Cliente.class.getCanonicalName()).log(Level.SEVERE, null, ex);
        }
    }
}