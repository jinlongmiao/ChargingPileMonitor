package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class ChargingPileImpl implements ChargingPile {

    private ParameterStore parameterStore;

    private EventDataReporterImpl eventDataReporterImpl;

    private RealTimeDataReporterImpl realTimeDataReporterImpl;

    public ChargingPileImpl() {
        //init
        parameterStore = new ParameterStore();
        // TODO: 2017/12/10
        eventDataReporterImpl = new EventDataReporterImpl.EventDataReporterBuilder().build();
        realTimeDataReporterImpl = new RealTimeDataReporterImpl.RealTimeDataReporterBuilder().build();
        //// TODO: 2017/12/10
        eventDataReporterImpl.start();
        realTimeDataReporterImpl.start();
    }

    public void setElectronicPrice(double jian, double feng, double ping, double gu) {
        parameterStore.setElectronicPrice(jian,feng,ping,gu);
    }

    public void setMaxRunningOutput(int outputPower, int outputCurrent, int outputVoltage) {
        parameterStore.setMaxRunningOutput(outputPower,outputCurrent,outputVoltage);
    }

    public void setClock(double timestamp) {
        parameterStore.setClock(timestamp);
        System.out.println("hehe");
    }

    public void setRealTimeReporter(Reporter realTimeReporter) {
        System.out.println("hehe");
    }

    public void setRealTimeDataReportPeriod(int periodMs) {
        System.out.println("hehe");
    }

    public void startCharging() {
        parameterStore.startCharging();
    }

    public void stopCharging() {
        parameterStore.stopCharging();
    }

    public void setRunningOutput(int voltage, int current) {
        parameterStore.setRunningOutput(voltage, current);
    }

}