package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface RemoteControl {

    void startCharging();

    void stopCharging();

    /**
     *
     * @param voltage 电压
     * @param current 电流
     */
    void setRunningOutput(int voltage, int current);
}
