package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface ParameterConfig {

    /**
     *
     * @param jian 尖电价
     * @param feng 峰电价
     * @param ping 平电价
     * @param gu 谷电价
     */
    void setElectronicPrice(double jian, double feng, double ping, double gu);

    void setMaxRunningOutput(int outputPower, int outputCurrent, int outputVoltage);

    void setClock(double timestamp);

    void setRealTimeReporter(Reporter realTimeReporter);

    void setRealTimeDataReportPeriod(int periodMs);
}
