package server;
import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class ServerManageClient {
	public ServerManageClient(){
        System.out.println("WebsocketTest..");
    }

    @OnOpen
    public void onopen(Session session){
        System.out.println("连接成功");
        try {
            session.getBasicRemote().sendText("hello client...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClose
    public void onclose(Session session){
    	try {
			session.getBasicRemote().sendText("Connection closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("close....");
    }
     @OnMessage      
    public void onsend(Session session,String msg){
        try {
        	while (true) {
        		session.getBasicRemote().sendText("client"+session.getId()+"say:"+msg);
        		Thread.sleep(1000);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
