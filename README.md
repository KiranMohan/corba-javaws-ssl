corba-javaws-ssl
================

Sample application to test CORBA IIOP over SSL with Web Start application

Setup
-----
1. Install Jacorb 3.5 to C:\apps. If you choose a different location, edit the property JACORB in corba-javaws-ssl/pom.xml
2. Create $JACORB/etc/jacorb.properties from the $JACORB/etc/jacorb_properties.template file
3. Configure the below properties in the $JACORB/etc/jacorb.properties.
   * ORBInitRef.NameService
   * jacorb.naming.ior_filename
4. Edit $JACORB/bin/ns and change the following line  
	jaco org.jacorb.naming.NameServer %*  
	to  
	jaco org.jacorb.naming.NameServer -DOAPort=57419 %*
5. Run Naming Service $JACORB/bin/ns


Compiling
---------
"maven clean install" from root directory

Running
-------
You can run the modules corba-helloworld-server and corba-helloword-client as standalone processes with maven itself.
* cd < module >
* maven exec:exec

