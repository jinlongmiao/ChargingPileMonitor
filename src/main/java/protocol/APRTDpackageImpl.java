package protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import simulator.dataItem.AllPeriodRealTimeData;
/*   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |  flag |   A   | B | C | D | E | F | G | H |   I   | J | K |   |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          input voltageA       |          input voltageB       |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          input voltageC       |          input currentA       |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          input currentA       |          input currentB       |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          input currentB       |          input currentC       |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |          input currentC       | guide voltage |  BMS voltage  |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * |         probe temperature     |              blank            |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * 
 * A=workingStatus;B=maintainDoorStatus;
 * C=electronicLockStatus;D=stopButtonStatus;
 * E=vehicleConnectingStatus;F=arresterStatus;
 * G=vehicleConnectGuideStatus;H=directCurrentContactorStatus;
 * I=directCurrentContactorFaultStatus;J=chargingModuleFault;
 * K=insulationFault
 */
public class APRTDpackageImpl implements APRTDpackage {
	@Override
	public byte[] toWire(AllPeriodRealTimeData data) throws IOException {
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bStream);
		byte[] status = getStatusByte(data);
		out.write(status);
		byte[] voltage = getInputVoltage(data);
		out.write(voltage);
		byte[] current = getCurrent(data);
		out.write(current);
		byte auxiliaryVoltage = getAuxiliaryVoltage(data);
		out.write(auxiliaryVoltage);
		byte temperature = getTemperature(data);
		out.write(temperature);
		out.flush();
		byte[] data1 = bStream.toByteArray();
		return data1;
	}

	private byte getTemperature(AllPeriodRealTimeData data) {
		byte b = (byte) data.getChargerProbeTemperature();
		return b;
	}

	private byte[] getInputVoltage(AllPeriodRealTimeData data) {
		byte[] b = new byte[3];
		int[] array1 = new int[] { data.getAcInputVoltageA(),
				data.getAcInputVoltageB(), data.getAcInputVoltageC() };
		for (int i = 0; i < array1.length; i++) {
			int voltage = array1[i];
			b[i] = (byte) voltage;
		}
		return b;
	}

	private byte[] getCurrent(AllPeriodRealTimeData data) {
		byte[] b = new byte[6];
		int[] array1 = new int[] { data.getAcInputCurrentA(),
				data.getAcInputCurrentB(), data.getAcInputCurrentC() };
		for (int i = 0, j = 0; i < array1.length; i++, j += 2) {
			int current = array1[i];
			b[j] = (byte) (current >> 8);
			b[j + 1] = (byte) current;
		}
		return b;
	}

	private byte getAuxiliaryVoltage(AllPeriodRealTimeData data) {
		byte b = 0;
		int[] array1 = new int[] { data.getVehicleGuideVoltage(),
				data.getBMSAuxiliaryVoltage() };
		b = (byte) ((array1[0] << 4) | array1[1]);
		return b;
	}

	private byte[] getStatusByte(AllPeriodRealTimeData data) {
		byte[] b = new byte[2];
		int flag = 1;
		int[] array1 = new int[] { data.getWorkingStatus() + 2,
				data.getMaintainDoorStatus(), data.getElectronicLockStatus(),
				data.getStopButtonStatus(), data.getVehicleConnectingStatus() };
		int[] array2 = new int[] { data.getArresterStatus(),
				data.getVehicleConnectGuideStatus(),
				data.getDirectCurrentContactorStatus(),
				data.getDirectCurrentContactorFaultStatus() + 2,
				data.getChargingModuleFault(), data.getInsulationFault() };
		for (int i : array1) {
			if (i >= 2) {
				b[0] = (byte) ((b[0] << 2) | (i - 2));
			} else {
				b[0] = (byte) ((b[0] << 1) | i);
			}
		}
		for (int i : array2) {
			if (i >= 2) {
				b[1] = (byte) ((b[1] << 2) | (i - 2));
			} else {
				b[1] = (byte) ((b[1] << 1) | i);
			}
		}
		b[1] <<= 1;
		return b;
	}

	@Override
	public AllPeriodRealTimeData fromWire(byte[] input) {
		AllPeriodRealTimeData data = new AllPeriodRealTimeData();
		analysisStatus(data, input);
		analysisVoltage(data, input);
		analysisCurrent(data, input);
		analysisAuxiliaryVoltageAndTemperature(data, input);
		return data;
	}

	private void analysisStatus(AllPeriodRealTimeData data, byte[] input) {
		data.setWorkingStatus((input[0] >> 4) & 3);
		data.setMaintainDoorStatus((input[0] >> 3) & 1);
		data.setElectronicLockStatus((input[0] >> 2) & 1);
		data.setStopButtonStatus((input[0] >> 1) & 1);
		data.setVehicleConnectingStatus(input[0] & 1);
		data.setArresterStatus((input[1] >> 7) & 1);
		data.setVehicleConnectGuideStatus((input[1] >> 6) & 1);
		data.setDirectCurrentContactorStatus((input[1] >> 5) & 1);
		data.setDirectCurrentContactorFaultStatus((input[1] >> 3) & 3);
		data.setChargingModuleFault((input[1] >> 2) & 1);
		data.setInsulationFault((input[1] >> 1) & 1);
	}

	private void analysisVoltage(AllPeriodRealTimeData data, byte[] input) {
		data.setAcInputVoltageA(input[2] & 0xff);
		data.setAcInputVoltageB(input[3] & 0xff);
		data.setAcInputVoltageC(input[4] & 0xff);
	}

	private void analysisCurrent(AllPeriodRealTimeData data, byte[] input) {
		data.setAcInputCurrentA(((input[5] << 8) ^ input[6]) & 0xff);
		data.setAcInputCurrentB(((input[7] << 8) ^ input[8]) & 0xff);
		data.setAcInputCurrentC(((input[9] << 8) ^ input[10]) & 0xff);
	}

	private void analysisAuxiliaryVoltageAndTemperature(
			AllPeriodRealTimeData data, byte[] input) {
		data.setVehicleGuideVoltage((input[11] >> 4) & 0x0f);
		data.setBMSAuxiliaryVoltage(input[11] & 0x0f);
		data.setChargerProbeTemperature(input[12] & 0xff);
	}
}
