import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Properties;

class HelloImpl extends HelloPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val;
  }

  // implement sayHello() method
  public String sayHello() {
    return "\nHello world !!\n";
  }

  public int suma(int a, int b) {
    return a + b;
  }

  public int restar(int a, int b) {
    return a - b;
  }

  public int multiplicar(int a, int b) {
    return a * b;
  }

  public int dividir(int a, int b) {
    return a / b;
  }

  public int factorial(int a) {
    int fact = 1;
    for (int i = 1; i <= a; i++) {
      fact = fact * i;
    }
    return fact;
  }

  public int potencia(int a, int b) {
    int resultado = 1;
    for (int i = 1; i <= b; i++) {
      resultado *= a;
    }
    return resultado;
  }

  public int logaritmo(int a) {
    return (int) Math.log(a);
  }

  public int raiz(int a) {
    return (int) Math.sqrt(a);
  }

  public String derivar(int c, int[] d) {
    ArrayList<Integer> coeficientes = new ArrayList<Integer>(10);
    for (int i = 0; i < c + 1; i++) {
      coeficientes.add(d[i]);
    }
    for (int i = 0; i < c + 1; i++) {
      coeficientes.set(i, coeficientes.get(i) * i);
    }
    String resultado = "";
    for (int i = 0; i < c + 1; i++) {
      if (i == c)
        resultado += "";
      else if (i == c - 1)
        resultado += coeficientes.get(c - i) + "x^" + (c - i - 1);
      else
        resultado += coeficientes.get(c - i) + "x^" + (c - i - 1) + " + ";

    }
    return resultado;
  }

  // implement shutdown() method
  public void shutdown() {
  }

}

public class HelloServer {

  public static void main(String args[]) {
    try {
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      HelloImpl helloImpl = new HelloImpl();
      helloImpl.setORB(orb);

      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
      Hello href = HelloHelper.narrow(ref);

      System.out.println(orb.object_to_string(ref));

      // get the root naming context
      // NameService invokes the name service
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Hello Test";
      NameComponent path[] = ncRef.to_name(name);
      ncRef.rebind(path, href);

      System.out.println("HelloServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    }

    catch (Exception e) {
      System.err.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }

    System.out.println("HelloServer Exiting ...");

  }
}
