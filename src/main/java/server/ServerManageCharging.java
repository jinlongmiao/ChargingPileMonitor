package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerManageCharging implements Runnable {
	private int port;

	public ServerManageCharging(int port) {
		this.port = port;
	}

	public void run() {
		try {
			System.out.println("Server starting...");
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server started.");
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new SocketThread(socket)).start();;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
