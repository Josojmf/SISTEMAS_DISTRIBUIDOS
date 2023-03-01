#CORBA HELLO world server
import sys, os
from omniORBpy import CORBA, PortableServer
import CosNaming, Hello
import _GlobalIDL, _GlobalIDL__POA
# Initialize the ORB
orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
# Get a reference to the root naming context
obj = orb.resolve_initial_references("NameService")
# Narrow the object to a naming context
rootContext = obj._narrow(CosNaming.NamingContext)
# Bind a context called "test" to the root context
name = [CosNaming.NameComponent("test","my_context")]
try:
    testContext = rootContext.bind_new_context(name)
except CosNaming.NamingContext.AlreadyBound:
    obj = rootContext.resolve(name)
    testContext = obj._narrow(CosNaming.NamingContext)
# Bind the object to the test context
name = [CosNaming.NameComponent("Hello","Object")]
try:
    testContext.bind(name, hello._this())
except CosNaming.NamingContext.AlreadyBound:
    testContext.rebind(name, hello._this())
# Activate the POA manager
poaManager = poa._get_the_POAManager()
poaManager.activate()
# Run the ORB
orb.run()
# Path: Practicas/Practica_2/Client.py
# Compare this snippet from Practicas/Practica_2/sERVER.PY:
# #CORBA HELLO WORLD SERVER
# import sys, os
# from omniORB import CORBA, PortableServer
# import CosNaming, Hello
# import _GlobalIDL, _GlobalIDL__POA
# # Initialize the ORB
# orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
# # Get a reference to the root naming context
# obj = orb.resolve_initial_references("NameService")
# # Narrow the object to a naming context
# rootContext = obj._narrow(CosNaming.NamingContext)
# # Bind a context called "test" to the root context
# name = [CosNaming.NameComponent("test","my_context")]
# try:
#     testContext = rootContext.bind_new_context(name)
# except CosNaming.NamingContext.AlreadyBound:
#     obj = rootContext.resolve(name)
#     testContext = obj._narrow(CosNaming.NamingContext)
# # Bind the object to the test context