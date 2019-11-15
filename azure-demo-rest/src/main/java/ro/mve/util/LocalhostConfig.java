package ro.mve.util;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.UnknownHostException;
import java.util.logging.Level;


public class LocalhostConfig {
	
	static {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	}
	
	public static void setProxyOnLocalHost() {
		try {
			if ( !InetAddress.getLocalHost().getHostAddress().equals(System.getenv("local_ip"))) {
				return ;
			}
		} catch (UnknownHostException e) {}

		System.getProperties().put( "jdk.http.auth.tunneling.disabledSchemes", "" );
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "proxyHost", "ps-bxl-usr.cec.eu.int" );
		System.getProperties().put( "proxyPort", "8012" );

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(System.getProperty("http.proxyUser"), System.getProperty("http.proxyPassword").toCharArray());
			}
		});
	}

}
