package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class ParameterStore implements ParameterConfig, RemoteControl{

    private double jianDianJia;
    private double fengDianJia;
    private double pingDianJia;
    private double guDianJia;

    private int outputPower;
    private int outputCurrent;
    private int outputVoltage;

    private double clock;

    private Reporter realTimeDataReporter;

    private boolean onCharging;
    private int volage;
    private int current;

    public void setElectronicPrice(double jian, double feng, double ping, double gu) {
        this.jianDianJia = jian;
        this.fengDianJia = feng;
        this.pingDianJia = ping;
        this.guDianJia = gu;
    }

    public void setMaxRunningOutput(int outputPower, int outputCurrent, int outputVoltage) {
        this.outputPower = outputPower;
        this.outputCurrent = outputCurrent;
        this.outputVoltage = outputVoltage;
    }

    public void setClock(double timestamp) {
        this.clock = timestamp;
    }

    public void setRealTimeReporter(Reporter realTimeReporter) {
        this.realTimeDataReporter = realTimeReporter;
    }

    public void setRealTimeDataReportPeriod(int periodMs) {
        if (this.realTimeDataReporter == null)
            throw new IllegalStateException("reporter null");
        if (periodMs <= 0)
            throw new IllegalArgumentException("periodMs must be greater than zero");
        realTimeDataReporter.setReportPeriod(periodMs);
    }

    public void startCharging() {
        if (onCharging)
            System.err.println("start an on charging chargingPile");
        onCharging = true;
        System.out.println("startCharging");
    }

    public void stopCharging() {
        if (!onCharging)
            System.err.println("stop an not on charging chargingPile");
        onCharging = false;
        System.out.println("stopCharging");
    }

    public void setRunningOutput(int voltage, int current) {
        this.volage = voltage;
        this.current = current;
    }
}
