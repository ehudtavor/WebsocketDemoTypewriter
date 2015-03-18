package ehudtavor;

import java.io.IOException;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/typewriter")
public class WebsocketEndpointTypewriter
{

	@OnMessage
	public void onMessage(String message, Session websocketSession) throws IOException, InterruptedException
	{
		// Print the client message for testing purposes
		System.out.println("ServerEndpoint: received: " + message);

		// Send the message back to the client
		websocketSession.getBasicRemote().sendText(message);
	}

	@OnOpen
	public void onOpen(Session websocketSession)
	{
		System.out.println("ServerEndpoint: session opened: " + websocketSession.getId());
	}

	@OnClose
	public void onClose(Session websocketSession)
	{
		System.out.println("ServerEndpoint: session closed: " + websocketSession.getId());
	}

}
