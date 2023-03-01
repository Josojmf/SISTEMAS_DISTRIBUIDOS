import java.io.*;
import java.util.*;
import MCalculadora.*;

public class ImplementacionFunciones extends ICalculadoraPOA {
    public ImplementacionFunciones() {
        super();
    }

    public int sumar(Operadores ops) {
        return ops.a + ops.b;
    }

    public int restar(Operadores ops) {
        return ops.a - ops.b;
    }

    public int multiplicar(Operadores ops) {
        return ops.a * ops.b;
    }

    public int dividir(Operadores ops) {
        return ops.a / ops.b;
    }

    public int factorial(Operadores ops) {
        int factorial = 0;
        return ops.a * ops.a;
    }
}