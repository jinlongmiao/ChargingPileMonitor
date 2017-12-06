package simulator;

import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class ChargingPileImpl implements ChargingPile {

    private ParameterStore parameterStore;

    private EventDataReporter eventDataReporter;

    private RealTimeDataReporter realTimeDataReporter;

    public void reportEventRecord(EventRecord eventRecord) {
        System.out.println("hehe");
    }

    public void reportFaultAlarmRecord(FaultAlarmRecord faultAlarmRecord) {
        System.out.println("hehe");
    }

    public void reportChargingDealRecord(ChargingDealRecord chargingDealRecord) {
        System.out.println("hehe");
    }

    public void setElectronicPrice(double jian, double feng, double ping, double gu) {
        System.out.println("hehe");
    }

    public void setMaxRunningOutput(int outputPower, int outputCurrent, int outputVoltage) {
        System.out.println("hehe");
    }

    public void setClock(double timestamp) {
        System.out.println("hehe");
    }

    public void setRealTimeReporter(Reporter realTimeReporter) {
        System.out.println("hehe");
    }

    public void setRealTimeDataReportPeriod(int periodMs) {
        System.out.println("hehe");
    }

    public void reportAllPeriodRealTimeData(AllPeriodRealTimeData data) {
        System.out.println("hehe");
    }

    public void reportOutputData(ChargingOutputData outputData) {
        System.out.println("hehe");
    }

    public void reportBMSData(BMSData bmsData) {
        System.out.println("hehe");
    }

    public void startCharging() {
        System.out.println("hehe");
    }

    public void stopCharging() {
        System.out.println("hehe");
    }

    public void setRunningOutput(int voltage, int current) {
        System.out.println("hehe");
    }

    public void setNetInterface(Object out) {
        System.out.println("hehe");
    }

    public void setReportPeriod(double periodMs) {
        System.out.println("hehe");
    }
}