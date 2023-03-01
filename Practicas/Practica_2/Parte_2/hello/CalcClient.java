Skip to content Search or jump to…Pull requests Issues Codespaces Marketplace Explore

@Josojmf prathamvasa/Functional-Calculator-using-CORBA-Client-Server-Programming Public Fork your own copy of prathamvasa/Functional-Calculator-using-CORBA-Client-Server-Programming Code Issues Pull requests Actions Projects Security Insights Functional-Calculator-using-CORBA-Client-Server-Programming/Calc/CalcClient.java/@prathamvasa prathamvasa updated Latest commit d47e731 on Apr 2,2016 History 1 contributor 128 lines(73 sloc)2.2 KB

//Import all the important packages

//Import the package which contains the Client Stub
import PrathamCalculator.*;

//Import the below two packages to use the Naming Service
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

//Import this package to run the CORBA Applicaion
import org.omg.CORBA.*;

//Import to perform Input-Output functionalities
import java.io.*;
import java.util.*;

public class CalcClient

{

  static Calc cimpl;

  public static void main(String args[])

  {

    try

    {

      // Declaring and initializing the variables

      int dec = 1;
      int i = 0;
      int j = 0;
      int k = 0;
      int result = 0;
      int x = 1;
      char c = 'x';
      char d = 'y';
      char f = 'z';
      String abc = "vas";

      // Create and Initialize the ORB object
      // init() allows to set properties at run time

      ORB orb = ORB.init(args, null);

      // ORB helps the Client to locate the actual services which it needs
      // COS Naming Service helps the client to do so

      // Obtain the initial Naming Context
      // Obtain an object reference to the name server

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

      // Narrow the objref to its proper type

      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // Identify a String to refer the Naming Service to Calc object

      String name = "Calc";

      // Get a reference to the CalcServer and Narrow it to Calc object

      cimpl = CalcHelper.narrow(ncRef.resolve_str(name));
      System.out.println("Obtained a handle on the server object");

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      while (x == 1)

      {

        System.out.println("Enter the string:");
        abc = br.readLine();

        // Separate the input string into separate characters

        c = abc.charAt(0);
        d = abc.charAt(1);
        f = abc.charAt(2);

        // Get the ASCII value of the Operator

        i = (int) c;

        // Get the Integer values of the other two characters

        j = Character.getNumericValue(d);
        k = Character.getNumericValue(f);

        result = cimpl.calculate(i, j, k);
        System.out.println("The result of the operation is " + result);

        System.out.println("Enter 1 to continue and 0 to exit ");
        x = Integer.parseInt(br.readLine());
      }

      // If the Client wants to discontinue
      cimpl.shutdown();

    }

    catch (Exception e)

    {

      System.out.println("ERROR : " + e);
      e.printStackTrace(System.out);

    }

  }// end of main()

}// end of class

Footer©2023 GitHub,

Inc.Footer navigation
Terms Privacy
Security Status
Docs

Contact
GitHub
Pricing
API
Training
Blog
About Functional-Calculator-using-CORBA-Client-Server-Programming/CalcClient.java at master·prathamvasa/Functional-Calculator-using-CORBA-Client-Server-
Programming