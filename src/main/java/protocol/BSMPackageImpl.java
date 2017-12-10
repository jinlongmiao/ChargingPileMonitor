package protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import simulator.dataItem.AllPeriodRealTimeData;
import simulator.dataItem.ChargingBMSData;

/*   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |  flag |                 battery volume                        |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |                        charging volume                        |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |                            bms volume                         |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |                      charging max volume                      |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |       charging current        |           bms current         |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |      charging max current     | single max cur|single min cur |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |      single max temperature   |     single min temperature    |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |                         time to charge                        |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |                          battery type                         |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          charging soc         |          vehicle soc          |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * 
 */
public class BSMPackageImpl implements BSMPackage {
	@Override
	public byte[] toWire(ChargingBMSData data) throws IOException {
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bStream);
		byte[] voltage = getVoltage(data);
		out.write(voltage);
		byte[] current = getCurrent(data);
		out.write(current);
		byte max_min_voltage = getMaxMinVoltage(data);
		out.write(max_min_voltage);
		byte[] temperature = getTemperature(data);
		out.write(temperature);
		byte[] time = getTime(data);
		out.write(time);
		byte[] type = getType(data);
		out.write(type);
		byte[] soc = getSoc(data);
		out.write(soc);
		out.flush();
		byte[] data1 = bStream.toByteArray();
		return data1;
	}

	private byte[] getVoltage(ChargingBMSData data) {
		byte[] b = new byte[8];
		int[] array1 = new int[] { data.getBatteryVol(), data.getChargingVol(),
				data.getBatteryVol(), data.getChargingMaxVol() };
		for (int i = 0, j = 0; i < array1.length; i++, j += 2) {
			int current = array1[i];
			b[j] = (byte) (current >> 8);
			b[j + 1] = (byte) current;
		}
		b[0] = (byte) (0x40 + b[0]);
		return b;
	}

	private byte[] getCurrent(ChargingBMSData data) {
		byte[] b = new byte[3];
		int[] array1 = new int[] { data.getChargingCur(), data.getBmsCur(),
				data.getChargingMaxCur() };
		for (int i = 0; i < array1.length; i++) {
			int voltage = array1[i];
			b[i] = (byte) voltage;
		}
		return b;
	}

	private byte getMaxMinVoltage(ChargingBMSData data) {
		byte b = 0;
		int[] array1 = new int[] { data.getSingleMaxVol(),
				data.getSingleMinVol() };
		b = (byte) ((array1[0] << 4) | array1[1]);
		return b;
	}

	private byte[] getTemperature(ChargingBMSData data) {
		byte[] b = new byte[2];
		int[] array1 = new int[] { data.getSingleMaxTemp(),
				data.getSingleMinTemp() };
		for (int i = 0; i < array1.length; i++) {
			int voltage = array1[i];
			b[i] = (byte) voltage;
		}
		return b;
	}

	private byte[] getTime(ChargingBMSData data) {
		byte[] b = new byte[2];
		int[] array1 = new int[] { data.getTimeToCharge() };
		for (int i = 0, j = 0; i < array1.length; i++, j += 2) {
			int current = array1[i];
			b[j] = (byte) (current >> 8);
			b[j + 1] = (byte) current;
		}
		return b;
	}

	private byte[] getType(ChargingBMSData data) {
		byte[] b = new byte[2];
		int[] array1 = new int[] { data.getBatteryType() };
		for (int i = 0, j = 0; i < array1.length; i++, j += 2) {
			int current = array1[i];
			b[j] = (byte) (current >> 8);
			b[j + 1] = (byte) current;
		}
		return b;
	}

	private byte[] getSoc(ChargingBMSData data) {
		byte[] b = new byte[2];
		int[] array1 = new int[] { (int) (data.getChargingSoc() * 100),
				(int) (data.getVehSoc() * 100) };
		for (int i = 0; i < array1.length; i++) {
			int voltage = array1[i];
			b[i] = (byte) voltage;
		}
		return b;
	}

	@Override
	public ChargingBMSData fromWire(byte[] input) throws IOException {
		ChargingBMSData data = new ChargingBMSData();
		analysisSOC(data, input);
		analysisType(data, input);
		analysisTime(data, input);
		analysisTemperature(data, input);
		analysisVoltage(data, input);
		analysisCurrent(data, input);
		return data;
	}

	private void analysisVoltage(ChargingBMSData data, byte[] input) {
		data.setBatteryVol((((input[0] << 8) & 0x3fff) ^ input[1]) & 0xffff);
		data.setChargingVol(((input[2] << 8) ^ input[3]) & 0xffff);
		data.setBmsVol(((input[4] << 8) ^ input[5]) & 0xffff);
		data.setChargingMaxVol(((input[6] << 8) ^ input[7]) & 0xffff);
		data.setSingleMaxVol((input[11] >> 4) & 0x0f);
		data.setSingleMinVol(input[11] & 0x0f);
	}

	private void analysisCurrent(ChargingBMSData data, byte[] input) {
		data.setChargingCur((input[8]) & 0xff);
		data.setBmsCur((input[9]) & 0xff);
		data.setChargingMaxCur((input[10]) & 0xff);
	}

	private void analysisTemperature(ChargingBMSData data, byte[] input) {
		data.setSingleMaxTemp(input[12] & 0xff);
		data.setSingleMinTemp(input[13] & 0xff);
	}

	private void analysisTime(ChargingBMSData data, byte[] input) {
		data.setTimeToCharge(((input[14] << 8) ^ input[15]) & 0xffff);
	}

	private void analysisType(ChargingBMSData data, byte[] input) {
		data.setBatteryType((input[16] << 8 ^ (input[17] & 0xff)) & 0xffff);
	}

	private void analysisSOC(ChargingBMSData data, byte[] input) {
		data.setChargingSoc((input[18] & 0xff) / 100.0);
		data.setVehSoc((input[19] & 0xff) / 100.0);
	}

	public static void main(String[] args) throws IOException {
		ChargingBMSData data = new ChargingBMSData();
		System.out.println(data);
		System.out.println(new BSMPackageImpl().fromWire(new BSMPackageImpl()
				.toWire(data)));

	}
}
