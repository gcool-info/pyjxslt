package org.pyjxslt;

import py4j.GatewayServer;
import py4j.CallbackClient;
import java.net.InetAddress;

public class StartGateway {
	/**
	 * Start an XSLT Gateway server.
	 * 
	 * @param args argument
	 */
	public static void main(String[] args) {
		GatewayServer gatewayServer;

		int port = 25333;
		final String LOCAL_HOST = "127.0.0.1";
		InetAddress address = null;
		try {
			address = InetAddress.getByName(LOCAL_HOST);
		} catch(Exception ex) {
			System.err.println("Invalid default address " + LOCAL_HOST);
		}

		if (args.length == 2) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Invalid Port Number: " + args[0]);
				System.exit(1);
			}
			try {
				address = InetAddress.getByName(args[1]);
			} catch(Exception ex) {
				System.err.println("Invalid address " + args[1]);
			}
		} else if (args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Invalid Port Number: " + args[0]);
				System.exit(1);
			}
		} else if (args.length != 0) {
			System.err.println("Usage: StartGateway [port] [address]");
			System.exit(1);
		}

		gatewayServer = new GatewayServer(null, port, 0, address, null, 0, 0, null);
		gatewayServer.start();
		System.out.print("Gateway Server Started on port " + port + " and address " + address);
	}
}
