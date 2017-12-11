package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ChargingPileClient implements Runnable {
	private String clientName;
	private int serverPort;

	public ChargingPileClient(String clientName, int serverPort) {
		this.clientName = clientName;
		this.serverPort = serverPort;
	}

	public void run() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", serverPort);

			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			//客户端发送的数据
			printWriter.print("Hello, Server. I am " + clientName);
			printWriter.flush();
			socket.shutdownOutput();

			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			String message = "";
			while ((line = bufferedReader.readLine()) != null) {
				message += line;
			}
			//message为客户端从服务器端接收过来的消息
			System.out.println("The message recieved from server:" + message);
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
