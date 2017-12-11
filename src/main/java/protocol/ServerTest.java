package protocol;

import simulator.dataItem.ChargingPileData;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        ObjectDecoder objectDecoder = new ObjectDecoder();
        ObjectEncoder objectEncoder = new ObjectEncoder();
        ServerSocket server = new ServerSocket(23457);
        Socket socket = server.accept();
        System.out.println("连接成功");

        InputStream input = socket.getInputStream();
        CCSPackage ccs = new CCSPackage();
        ChargingPileData cpd = ccs.analyCCSPackage(input);
        System.out.println(cpd.getAcMaxTemp());
        System.out.println(cpd.getOutputCur());
        System.out.println(cpd.getOutputVol());
        System.out.println(cpd.getPower());
        System.out.println(cpd.getTime());

    }
}
