package protocol;

import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 23457);
        CCSPackage ccsp = new CCSPackage();
        byte[] ccs = new CCSPackage().getCCSByte(12,32,23,23,34);
        String s = new String(ccs);
        System.out.println(s);
        ccsp.sendCCS(client, ccs);
    }
}
