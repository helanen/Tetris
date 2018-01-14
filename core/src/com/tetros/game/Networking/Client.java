package com.tetros.game.Networking;


import com.badlogic.gdx.Gdx;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

//basic socketIO client that connects to the nodeJS backend
public class Client {
    private Socket socket;
    private static final String LOG = "SocketIO: ";
    private String clientId;


    public void connectSocket(){
        try{
            socket = IO.socket("http://localhost:8080"); //socket init
            Gdx.app.log(LOG, "Connecting to server");
            socket.connect();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void configSocketEvents(){
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Gdx.app.log(LOG, "Connected");
            }
        }).on("socketID", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                   setClientId(data.getString("id"));
                   Gdx.app.log(LOG, "Client ID: " + getClientId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).on("newPlayer", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                   String newID = data.getString("id");
                    Gdx.app.log(LOG, "New Player Connection: " + newID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String id) {
        this.clientId = id;
    }
}
