import sys, os
import HelloApp
from omniORB import CORBA
orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
ior = sys.argv[1]
obj = orb.string_to_object(ior)
hello = obj._narrow(HelloApp.Hello)
grado = 3;
coeficientes = [1,2,3,4]
funcion = ""
for i in range(0,grado+1):
    funcion = funcion + str(coeficientes[i]) + "x^" + str(i) + " + "
if hello is None:
    print ("Object reference is not an Hello")
    sys.exit(1)
print ("HOLA"+str(hello.sayHello()))
print("SUMA: "+ str(hello.suma(2,3)))
print("MULTIPLICACIÓN: "+ str(hello.multiplicar(2,3)))
print("DISVISION: "+str(hello.dividir(2,3)))
print("RESTA: "+str(hello.restar(2,3)))
print("POTENCIA: "+str(hello.potencia(2,3)))
print("FACTORIAL: "+str(hello.factorial(10)))
print("LOGARITMO: "+ str((hello.logaritmo(10))))
print("RAIZ: "+str(hello.raiz(10)))
print("DERIVADA DE:"+str(funcion)+" ES: "+str(hello.derivar(grado,coeficientes)))
