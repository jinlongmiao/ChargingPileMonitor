package simulator;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface Reporter {

    /**
     *
     * @param out
     */
    void setNetInterface(Object out);

    /**
     * 设置上报周期
     * @param periodMs
     */
    void setReportPeriod(double periodMs);
}
