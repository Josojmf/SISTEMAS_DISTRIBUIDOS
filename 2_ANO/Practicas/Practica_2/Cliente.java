import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Cliente {
	private static final String IP = "localhost"; // Puedes cambiar a localhost
	private static final int PUERTO = 1200; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calc"); //Buscar en el registro...
        Scanner sc = new Scanner(System.in);
        int eleccion;
		String name;
        float numero1, numero2;
		String resultado = null;
        String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Sumar\n[1] => Restar\n[2] => Multiplicar\n[3] => Dividir\n[4]Hola\nElige: ";
        do {
            System.out.println(menu);

            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = -1;
            }

            if(eleccion != -1){
            	System.out.println("Ingresa el número 1: ");
            	try{
                	numero1 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero1 = 0;
            	}

            	System.out.println("Ingresa el número 2: ");
            	try{
                	numero2 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero2 = 0;
            	}
				System.out.println("Ingresa tu nombre");
				name= sc.nextLine();
                switch (eleccion) {
	                case 0:
	                    resultado = String.valueOf(interfaz.sumar(numero1, numero2));
	                    break;
	                case 1:
						resultado = String.valueOf(interfaz.restar(numero1, numero2));
	                    break;
	                case 2:
	                    resultado =String.valueOf( interfaz.multiplicar(numero1, numero2));
	                    break;
	                case 3:
	                    resultado = String.valueOf(interfaz.dividir(numero1, numero2));
	                    break;
					case 4:
						resultado= "Hello " + name;

	            }
				if(eleccion!=4) {
					System.out.println("Resultado => " + (resultado));
					System.out.println("Presiona ENTER para continuar");
				}else {
					System.out.println(resultado);
				}
                sc.nextLine();
            }
        } while (eleccion != -1);
    }
}
