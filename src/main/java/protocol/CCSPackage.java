package protocol;

import simulator.dataItem.ChargingPileData;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.NumberFormat;

/**
 * PGN4608 充电机充电状态报文
 *
 */
public class CCSPackage{
    /**
     *
     * @param outputVol 充电机输出电压（V），200-750V
     * @param outputCur 充电机输出电流（A），0-250A
     * @param acMaxTemp 充电模块最高温度，小于95
     * @param power 充电电量（kWh），范围：0-999kWh
     * @param time 累计充电时间（min），范围：0-999min
     * @return
     */

    public byte[] getCCSByte(int outputVol, int outputCur, int acMaxTemp, int power, int time){// 将参数封装成byte数组报文
        int index = 0;
        String packageCode = "10";
        NumberFormat format = NumberFormat.getNumberInstance() ;
        format.setMinimumIntegerDigits(3);
        NumberFormat format1 = NumberFormat.getNumberInstance();
        format1.setMinimumIntegerDigits(2);
        String opv = format.format(outputVol);
        String opc = format.format(outputCur);
        String pow = format.format(power);
        String tim = format.format(time);
        String temp = format1.format(acMaxTemp);


        byte[] packageCodeByte = packageCode.getBytes();
        String s1 = new String(packageCodeByte);
        byte[] outputVolByte = opv.getBytes();
        String s2 = new String(outputVolByte);
        byte[] outputCurByte = opc.getBytes();
        byte[] acMaxTempByte = temp.getBytes();
        byte[] powerByte = pow.getBytes();
        byte[] timeByte = tim.getBytes();
        int len = packageCodeByte.length+outputCurByte.length+outputVolByte.length+acMaxTempByte.length+powerByte.length+timeByte.length;
        System.out.println("len"+len);

        byte[] CCSByte = new byte[len];

        for(int i = 0;i<packageCodeByte.length;i++){
            CCSByte[index++] = packageCodeByte[i];
        }
        for(int i = 0;i<outputVolByte.length;i++){
            CCSByte[index++] = outputVolByte[i];
        }
        for(int i = 0;i<outputCurByte.length;i++){
            CCSByte[index++] = outputCurByte[i];
        }
        for(int i = 0;i<acMaxTempByte.length;i++){
            CCSByte[index++] = acMaxTempByte[i];
        }
        for(int i = 0; i<powerByte.length;i++){
            CCSByte[index++] = powerByte[i];
        }
        for(int i= 0;i<timeByte.length;i++){
            CCSByte[index++] = timeByte[i];
        }

        String s = new String(CCSByte);
        System.out.println(s);
        return CCSByte;

    }

    public void sendCCS(Socket socket, byte[] ccsByte){   //发送CCS报文
        try {
            OutputStream output = socket.getOutputStream();
            output.write(ccsByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChargingPileData analyCCSPackage(InputStream input){   //解析收到的CCS报文
        ChargingPileData cpd = new ChargingPileData();
        byte[]packageCode = this.streamToBytes(input, 2);
        byte[] outputVolByte = this.streamToBytes(input, 3);
        String s = new String(outputVolByte.toString());
        byte[] outputCurByte = this.streamToBytes(input, 3);
        byte[] acMaxTempByte = this.streamToBytes(input, 2);
        byte[] powerByte = this.streamToBytes(input, 3);
        byte[] timeByte = this.streamToBytes(input, 3);
        cpd.setTime(Integer.parseInt(new String(timeByte)));
        cpd.setPower(Integer.parseInt(new String(powerByte)));
        cpd.setAcMaxTemp(Integer.parseInt(new String(acMaxTempByte)));
        cpd.setOutpuCur(Integer.parseInt(new String(outputCurByte)));
        cpd.setOutputVol(Integer.parseInt(new String(outputVolByte)));
        return cpd;


    }

    public byte[] streamToBytes(InputStream inputStream, int len) {
        byte[] bytes = new byte[len];
        try {
            inputStream.read(bytes, 0, len);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bytes;

    }


}
