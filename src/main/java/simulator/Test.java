package simulator;

import simulator.dataItem.*;

import java.io.ByteArrayOutputStream;

/**
 * Created by violetMoon on 2017/12/10.
 */
public class Test {

    public static void main(String[] args) {
        EventDataReporter eventDataReporter = null;
        RealTimeDataReporter realTimeDataReporter = null;
        if (false) {
            eventDataReporter.reportChargingDealRecord(new ChargingDealRecord());
            eventDataReporter.reportEventRecord(new EventRecord(System.currentTimeMillis(), EventRecord.EventType.CONFIG));
            eventDataReporter.reportFaultAlarmRecord(new FaultAlarmRecord());
            eventDataReporter.setOutputStream(new ByteArrayOutputStream());

            realTimeDataReporter.reportAllPeriodRealTimeData(new AllPeriodRealTimeData());
            realTimeDataReporter.reportBMSData(new ChargingBMSData());
            realTimeDataReporter.reportOutputData(new ChargingOutputData());
            realTimeDataReporter.setOutputStream(new ByteArrayOutputStream());
        }
    }
}
