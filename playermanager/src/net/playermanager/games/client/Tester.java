package net.playermanager.games.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import sun.misc.BASE64Encoder;

import net.playermanager.games.model.Player;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;


public class Tester {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		ClientResponse response = null; 
//		// Create one player
//		Player player = new Player();
//		player.setSquadNumber("3");
//		player.setFirstName("Left");
//		player.setLastName("Back");
//		response = 
//				service.path("rest").path("players").path(player.getSquadNumber())
//				.accept(MediaType.APPLICATION_XML).put(ClientResponse.class, player);
//		
//		// Return code should be 201 == created resource
//		System.out.println(response.getStatus());
//		
//		// Get the Players
//		System.out.println(
//				service.path("rest").path("players")
//				.accept(MediaType.TEXT_XML).get(String.class)
//				);
//		
//		// Get XML for application
//		System.out.println(
//				service.path("rest").path("players")
//				.accept(MediaType.APPLICATION_JSON).get(String.class)
//				);
//		
//		// Get JSON for application
//		System.out.println(
//				service.path("rest").path("players")
//				.accept(MediaType.APPLICATION_XML).get(String.class)
//				);
//		
//		// Get the  Player with id 1
//		System.out.println(
//				service.path("rest").path("players/1")
//				.accept(MediaType.APPLICATION_XML).get(String.class)
//				);
//		
//		// get Player with id 1 
//		service.path("rest").path("players/3").delete();
//		
//		// Get the all players, id 1 should be deleted
//		System.out.println(
//				service.path("rest").path("players")
//				.accept(MediaType.APPLICATION_XML).get(String.class));
//		
		
		// Create a Player
		Form form = new Form();
		form.add("number", "10");
		form.add("firstName", "Archie");
		form.add("lastName", "McLarnon");
//		response = service.path("rest").path("players")
//				.type(MediaType.APPLICATION_FORM_URLENCODED)
//				.post(ClientResponse.class, form);
		String token = "gerry:password"; 
        BASE64Encoder enc = new sun.misc.BASE64Encoder(); 
        String encodedAuthorization = enc.encode(token.getBytes()); 

        service.path("rest").path("players")
				.type(MediaType.APPLICATION_FORM_URLENCODED)
				.header("Authorization", "Basic " + encodedAuthorization)
				.post(ClientResponse.class, form);
		
		System.out.println("Form response " + response.getEntity(String.class));
		
		// Get the all players, id 4 should be created
//		System.out.println(
//				service.path("rest").path("players")
//				.accept(MediaType.APPLICATION_XML).get(String.class)
//				);
		
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/playermanager").build();
	}
}

