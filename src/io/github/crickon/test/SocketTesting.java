package io.github.crickon.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SocketTesting extends WebSocketClient {

    boolean connected = false;
    
    public SocketTesting(URI serverUri) {
        super(serverUri);
    }
    
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void onMessage(String str) {
        /*JsonElement elem = JsonParser.parseString(str);
        JsonObject obj = elem.getAsJsonObject();
        JsonElement eventTypeElement = obj.get("type");
        if (eventTypeElement != null) {
            System.out.println(eventTypeElement.getAsString());
        }*/
        System.out.println(str);
    }

    @Override
    public void onError(Exception e) {
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        connected = true;
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
    }

    public static void main(String[] args) {
        try {
            // "wss://push.planetside2.com/streaming?environment=ps2&service-id=s:"
            // + config.service_id;
            SocketTesting connection = new SocketTesting(new URI(
                "wss://push.planetside2.com/streaming?environment=ps2&service-id=s:tome95309"));
            connection.connect();
            
            while (!connection.isConnected()) {
                System.out.print(".");
            }
            System.out.println();
            connection.send("{\"service\":\"event\",\"action\":\"subscribe\",\"worlds\":[\"all\"],\"eventNames\":[\"PlayerLogin\",\"PlayerLogout\"]}");
        }
        catch (URISyntaxException e) {
            System.out.println("not a valid url");
        }
    }

}