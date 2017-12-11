package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread implements Runnable {

	private Socket socket;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			String message = "";
			while ((line = bufferedReader.readLine()) != null) {
				message += line;
			}
			System.out.println("Connect Success.");
			//message是服务器从客户端接受到的数据
			System.out.println("Message from client:" + message + ",IP address of Client:"
					+ socket.getInetAddress().getHostAddress());
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			//服务器发送的数据
			printWriter.print("Hello, Server has recieved your message!");
			printWriter.flush();
			socket.shutdownOutput();

			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
