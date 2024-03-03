import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Tests {
    private static final String IP = "localhost"; // Puedes cambiar a localhost
    private static final int PUERTO = 1200;

    private Cliente cliente;
    Registry registry;


    {
        try {
            registry = LocateRegistry.getRegistry(IP, PUERTO);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    Interfaz interfaz = (Interfaz) registry.lookup("Calc");

    public Tests() throws NotBoundException, RemoteException {
    }


    @Before
    public void setUp() {
        cliente = new Cliente(); // Suponiendo que tienes una clase Calculadora que contiene los métodos sumar, restar, multiplicar, dividir y sayHello
    }

    @Test
    public void testSumar() throws RemoteException {
        float resultado = interfaz.sumar(5.0f, 3.0f);
        assertEquals(8.0f, resultado, 0.001); // Tolerancia de margen de error de 0.001
    }

    @Test
    public void testRestar() throws RemoteException {
        float resultado = interfaz.restar(5.0f, 3.0f);
        assertEquals(2.0f, resultado, 0.001); // Tolerancia de margen de error de 0.001
    }

    @Test
    public void testMultiplicar() throws RemoteException {
        float resultado = interfaz.multiplicar(5.0f, 3.0f);
        assertEquals(15.0f, resultado, 0.001); // Tolerancia de margen de error de 0.001
    }

    @Test
    public void testDividir() throws RemoteException {
        float resultado = interfaz.dividir(6.0f, 3.0f);
        assertEquals(2.0f, resultado, 0.001); // Tolerancia de margen de error de 0.001
    }


}




