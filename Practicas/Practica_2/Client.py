#CORBA HELLO WORLD CLIENT
import sys, os
from omniORB import CORBA, PortableServer
import CosNaming, Hello
import _GlobalIDL, _GlobalIDL__POA
# Initialize the ORB
orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
# Get a reference to the root naming context
obj = orb.resolve_initial_references("NameService")
# Narrow the object to a naming context
rootContext = obj._narrow(CosNaming.NamingContext)