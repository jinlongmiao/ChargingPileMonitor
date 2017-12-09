package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface Reporter {

    void start();

    /**
     * once stopped, can't be restarted, should renew a reporter
     */
    void stop();
}
