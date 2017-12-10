package protocol;

import java.io.IOException;

import simulator.dataItem.AllPeriodRealTimeData;

public interface APRTDpackage {
	byte[] toWire(AllPeriodRealTimeData data) throws IOException;
	AllPeriodRealTimeData fromWire(byte[] input) throws IOException;
}
