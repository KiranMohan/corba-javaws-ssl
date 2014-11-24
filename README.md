corba-javaws-ssl
================

Sample application to test CORBA IIOP over SSL with Web Start application

Setup
-----
This project requires JacORB 3.5 installed for IDL compilation and running CORBA Naming Service

1. Install Jacorb 3.5 to C:\apps. If you choose a different location, edit the property JACORB in corba-javaws-ssl/pom.xml
2. Copy corba-helloworld-server/src/main/resources/jacorb.keystore to $JACORB/etc/
2. Create $JACORB/etc/jacorb.properties from the $JACORB/etc/jacorb_properties.template file
3. Configure the below properties in the $JACORB/etc/jacorb.properties.
   * ORBInitRef.NameService=file:/c:/NS_Ref
   * jacorb.naming.ior_filename=file:/c:/NS_Ref
   * jacorb.security.support_ssl=on
   * jacorb.ssl.socket_factory=org.jacorb.security.ssl.sun_jsse.SSLSocketFactory
   * jacorb.ssl.server_socket_factory=org.jacorb.security.ssl.sun_jsse.SSLServerSocketFactory
   * jacorb.security.ssl.client.supported_options=60
   * jacorb.security.ssl.client.required_options=60
   * jacorb.security.ssl.server.supported_options=60
   * jacorb.security.ssl.server.required_options=60
   * jacorb.security.keystore=$JACORB/etc/jacorb.keystore
   * jacorb.security.keystore_password=jacorb
   * jacorb.security.jsse.trustees_from_ks=on
4. Edit $JACORB/bin/ns and change the following line  
	`jaco org.jacorb.naming.NameServer %* ` 
	to  
	`jaco org.jacorb.naming.NameServer -DOAPort=57419 %*`
5. Run Naming Service $JACORB/bin/ns


Compiling
---------
"maven clean install" from root directory

Running
-------
You can run the modules corba-helloworld-server and corba-helloword-client as standalone processes with maven itself.
* cd < module >
* maven exec:exec

