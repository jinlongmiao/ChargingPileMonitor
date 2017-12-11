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

    private boolean onCharging;
    private int volage;
    private int current;

    public double getJianDianJia() {
        return jianDianJia;
    }

    public double getFengDianJia() {
        return fengDianJia;
    }

    public double getPingDianJia() {
        return pingDianJia;
    }

    public double getGuDianJia() {
        return guDianJia;
    }

    public int getOutputPower() {
        return outputPower;
    }

    public int getOutputCurrent() {
        return outputCurrent;
    }

    public int getOutputVoltage() {
        return outputVoltage;
    }

    public double getClock() {
        return clock;
    }

    public boolean isOnCharging() {
        return onCharging;
    }

    public int getVolage() {
        return volage;
    }

    public int getCurrent() {
        return current;
    }

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
