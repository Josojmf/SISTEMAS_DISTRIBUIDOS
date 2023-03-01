import MCalculadora.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class CalcServer {
    public CalcServer() {

    }

    public static void main(String[] args) {
        try {

            // Creación e Inicialización del ORB
            ORB orb = ORB.init(args, null);

            // Obtenemos las referencias a rootpoa y se activa el administrador POA
            // POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Se realiza la instancia para implementar las Funciones Remotas
            ImplementacionFunciones calcimp = new ImplementacionFunciones();

            // Se obtiene la referencia del servidor (servant)
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcimp);
            ICalculadora href = ICalculadoraHelper.narrow(ref);

            // Se obtiene la raiz del contexto de nombres de CORBA
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // NamingContextExt es parte de la especificación INS para interoperabilidad
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Se asigna el nombre del servicio para poder localizarlo en el servicio de
            // nombres (binding)
            String nombreServicio = "Calculadora";
            NameComponent path[] = ncRef.to_name(nombreServicio);
            ncRef.rebind(path, href);

            System.out.println("Servidor Calculadora Remota Lista!! ...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}