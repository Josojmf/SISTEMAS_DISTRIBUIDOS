package HelloApp;


/**
* HelloApp/OperadoresHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./Hello.idl
* mi�rcoles 1 de marzo de 2023 14H08' CET
*/

abstract public class OperadoresHelper
{
  private static String  _id = "IDL:HelloApp/Operadores:1.0";

  public static void insert (org.omg.CORBA.Any a, HelloApp.Operadores that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HelloApp.Operadores extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_array_tc (10, _tcOf_members0 );
          _members0[0] = new org.omg.CORBA.StructMember (
            "d",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (HelloApp.OperadoresHelper.id (), "Operadores", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HelloApp.Operadores read (org.omg.CORBA.portable.InputStream istream)
  {
    HelloApp.Operadores value = new HelloApp.Operadores ();
    value.d = new int[10];
    for (int _o0 = 0;_o0 < (10); ++_o0)
    {
      value.d[_o0] = istream.read_long ();
    }
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HelloApp.Operadores value)
  {
    if (value.d.length != (10))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    for (int _i0 = 0;_i0 < (10); ++_i0)
    {
      ostream.write_long (value.d[_i0]);
    }
  }

}
