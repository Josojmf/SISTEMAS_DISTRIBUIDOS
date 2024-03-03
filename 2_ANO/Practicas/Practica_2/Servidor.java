import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Servidor {
	private static final int PUERTO = 1200; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
        	/*
				Sobrescribir opcionalmente los métodos que escribimos en la interfaz
        	*/
            @Override
            public float sumar(float numero1, float numero2) throws RemoteException {
                return numero1 + numero2;
            };

            @Override
            public float restar(float numero1, float numero2) throws RemoteException {
                return numero1-numero2;
            }

            @Override
            public float multiplicar(float numero1, float numero2) throws RemoteException {
                return numero1 * numero2;
            };

            @Override
            public float dividir(float numero1, float numero2) throws RemoteException {
                return numero1 / numero2;
            }

            @Override
            public String sayHello(String name) throws RemoteException {
                return null;
            }

        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calc", remote); // Registrar calculadora
    }
}
