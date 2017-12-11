package server;

public class TestServerManageCharging {
	private static final int port = 8081;
	public static void main(String[] args) {
		new Thread(new ServerManageCharging(port)).start();
		new Thread(new ChargingPileClient("Client1", port)).start();
		new Thread(new ChargingPileClient("Client2", port)).start();
	}
}
