package protocol;

import java.io.IOException;

import simulator.dataItem.AllPeriodRealTimeData;
import simulator.dataItem.ChargingBMSData;

/**
 * PGN4864 BMS发送动力蓄电池状态信息报文
 */
public interface BSMPackage {
	byte[] toWire(ChargingBMSData data) throws IOException;

	ChargingBMSData fromWire(byte[] input) throws IOException;
}
