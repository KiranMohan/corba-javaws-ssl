package org.ktest.study.corba;

import java.util.Properties;

import org.jacorb.config.Configuration;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class HelloClient {
	static Hello helloImpl;

	public static void main(String args[]) {
	    System.out.println("Hello World Client starting up...");
	    Properties props = new Properties();
	    props.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
	    props.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
	    
		try {
		    
		    System.out.print("Initializing ORB...");
			// create and initialize the ORB
			ORB orb = ORB.init(args, props);
			System.out.println("Done.");
			
//			Configuration jacorbConfig = ((org.jacorb.orb.ORB)orb).getConfiguration();
//			for (String key : jacorbConfig.getAttributeNamesWithPrefix(""))
//			{
//			    System.out.println(key + " : " + jacorbConfig.getAttribute(key));
//			}

			// get the root naming context
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is
			// part of the Interoperable naming Service.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			System.out.println("Connected to Naming Service");

			// resolve the Object Reference in Naming
			String name = "Hello";
			helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

			System.out.println("Obtained a handle on server object: "
					+ helloImpl);
			System.out.println(helloImpl.sayHello());
			helloImpl.shutdown();

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

}