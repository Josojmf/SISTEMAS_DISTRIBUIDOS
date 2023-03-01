package MCalculadora;

/**
 * MCalculadora/_ICalculadoraStub.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from Calculadora.idl
 * Friday, February 24, 2023 7:40:37 PM CET
 */

public class _ICalculadoraStub extends org.omg.CORBA.portable.ObjectImpl implements MCalculadora.ICalculadora {

  public int sumar(MCalculadora.Operadores Ops) {
    org.omg.CORBA.portable.InputStream $in = null;
    try {
      org.omg.CORBA.portable.OutputStream $out = _request("sumar", true);
      MCalculadora.OperadoresHelper.write($out, Ops);
      $in = _invoke($out);
      int $result = $in.read_long();
      return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
      $in = $ex.getInputStream();
      String _id = $ex.getId();
      throw new org.omg.CORBA.MARSHAL(_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
      return sumar(Ops);
    } finally {
      _releaseReply($in);
    }
  } // sumar

  public int restar(MCalculadora.Operadores Ops) {
    org.omg.CORBA.portable.InputStream $in = null;
    try {
      org.omg.CORBA.portable.OutputStream $out = _request("restar", true);
      MCalculadora.OperadoresHelper.write($out, Ops);
      $in = _invoke($out);
      int $result = $in.read_long();
      return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
      $in = $ex.getInputStream();
      String _id = $ex.getId();
      throw new org.omg.CORBA.MARSHAL(_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
      return restar(Ops);
    } finally {
      _releaseReply($in);
    }
  } // restar

  public int multiplicar(MCalculadora.Operadores Ops) {
    org.omg.CORBA.portable.InputStream $in = null;
    try {
      org.omg.CORBA.portable.OutputStream $out = _request("multiplicar", true);
      MCalculadora.OperadoresHelper.write($out, Ops);
      $in = _invoke($out);
      int $result = $in.read_long();
      return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
      $in = $ex.getInputStream();
      String _id = $ex.getId();
      throw new org.omg.CORBA.MARSHAL(_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
      return multiplicar(Ops);
    } finally {
      _releaseReply($in);
    }
  } // multiplicar

  public int dividir(MCalculadora.Operadores Ops) {
    org.omg.CORBA.portable.InputStream $in = null;
    try {
      org.omg.CORBA.portable.OutputStream $out = _request("dividir", true);
      MCalculadora.OperadoresHelper.write($out, Ops);
      $in = _invoke($out);
      int $result = $in.read_long();
      return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
      $in = $ex.getInputStream();
      String _id = $ex.getId();
      throw new org.omg.CORBA.MARSHAL(_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
      return dividir(Ops);
    } finally {
      _releaseReply($in);
    }
  } // dividir

  public int factorial(MCalculadora.Operadores Ops) {
    org.omg.CORBA.portable.InputStream $in = null;
    try {
      org.omg.CORBA.portable.OutputStream $out = _request("fractorial", true);
      MCalculadora.OperadoresHelper.write($out, Ops);
      $in = _invoke($out);
      int $result = $in.read_long();
      return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
      $in = $ex.getInputStream();
      String _id = $ex.getId();
      throw new org.omg.CORBA.MARSHAL(_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
      return factorial(Ops);
    } finally {
      _releaseReply($in);
    }
  } // dividir

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
      "IDL:MCalculadora/ICalculadora:1.0" };

  public String[] _ids() {
    return (String[]) __ids.clone();
  }

  private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
    String str = s.readUTF();
    String[] args = null;
    java.util.Properties props = null;
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
    try {
      org.omg.CORBA.Object obj = orb.string_to_object(str);
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
      _set_delegate(delegate);
    } finally {
      orb.destroy();
    }
  }

  private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
    String[] args = null;
    java.util.Properties props = null;
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
    try {
      String str = orb.object_to_string(this);
      s.writeUTF(str);
    } finally {
      orb.destroy();
    }
  }
} // class _ICalculadoraStub
