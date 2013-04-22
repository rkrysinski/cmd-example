package com.krycha.example;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		if (args.length == 1) {

			String host = "host.com";
			String user = "rkrysinski";
			String password = "rkrysinski";
			String file = args[0];

			try {
				// scp file to the server
				Scp scp = new Scp();
				scp.setFile(file);
				scp.setPassword(password);
				scp.setHost(host);
				String toDir = user + "@" + host + ":/tmp";
				scp.setTodir(toDir);
				scp.setTrust(true);
				scp.setSftp(true);
				scp.execute();
			} catch (BuildException e) {
				System.out.println(e.getStackTrace());
			}

			System.out.println("File copyined: " + file + " -> " + user + "@"
					+ host + ":/tmp");

		} else {
			System.out.println("Error: provide file to copy.");
		}
	}
}
