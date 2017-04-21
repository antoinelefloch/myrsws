/**
 *
 * Description: 
 *
 * Note: You can copy this source code, but you need to keep these 2 lines in your file header.
 * author:  https://github.com/antoinelefloch
 *
 */
package com.alefloch.services.myrsws;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

// Jersey RESTful Web Services
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * @author lefla
 *
 */
public class MyMain {

	public static void main(String[] args) throws Exception {
		System.out.println("starting Jetty...");

		// Jersey
		ResourceConfig config = new ResourceConfig(Resource.class);
		config.register(JacksonFeature.class);
		
		// Jetty
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));
		Server server = new Server(2222);
		
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}
}
