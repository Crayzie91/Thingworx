package com.thingworx.sdk.simple;

import com.thingworx.communications.client.ClientConfigurator;
import com.thingworx.communications.client.ConnectedThingClient;
import com.thingworx.communications.client.things.VirtualThing;

public class TunnelExample {

	// Substitute your thing name here
	private static final String ThingName = "TunnelThing";

	public static void main(String[] args) {
		
		// Create a client config
		ClientConfigurator config = new ClientConfigurator();

		// Basic configuration. See SimpleClient.java for additional info.
		config.setUri("wss://localhost:443/Thingworx/WS");
		config.setAppKey("32491397-f468-4dbc-858a-376ff92aae02");
		config.ignoreSSLErrors(true);

		// Ensure tunnels are enabled for this example
		config.tunnelsEnabled(true);

		try {

			ConnectedThingClient client = new ConnectedThingClient(config);

			VirtualThing myThing = new VirtualThing(ThingName, "Tunnel Example", client);

			client.bindThing(myThing);
			client.start();

			while (!client.isShutdown()) {
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
