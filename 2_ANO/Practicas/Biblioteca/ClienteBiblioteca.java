import Biblioteca.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class ClienteBiblioteca {
    public static void main(String args[]) {
        try {
            // Inicializar el ORB (Object Request Broker)
            ORB orb = ORB.init(args, null);

            // Obtener referencia al servicio de nombres
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Buscar la referencia del objeto (servidor) en el servicio de nombres
            String name = "GestionBiblioteca";
            GestionBiblioteca gestionBiblioteca = GestionBibliotecaHelper.narrow(ncRef.resolve_str(name));

            // Usar la interfaz para llamar a las operaciones del servidor
            // Ejemplo: Buscar un libro
            String tituloLibro = "El principito";
            Libro libro = gestionBiblioteca.buscarLibro(tituloLibro);
            System.out.println("Libro encontrado: " + libro.titulo + ", " + libro.autor + ", ISBN: " + libro.ISBN);

            // Ejemplo: Prestar un libro
            boolean resultadoPrestamo = gestionBiblioteca.prestarLibro(libro.ISBN);
            if (resultadoPrestamo) {
                System.out.println("Libro prestado con éxito.");
            } else {
                System.out.println("El libro no está disponible para préstamo.");
            }

            // Continuar con más operaciones según sea necesario...

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}

