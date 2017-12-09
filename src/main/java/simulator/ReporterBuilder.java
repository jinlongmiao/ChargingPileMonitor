package simulator;

import java.io.OutputStream;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface ReporterBuilder {

    /**
     *
     * @param out
     */
    void setNetInterface(OutputStream out);

    /**
     * 设置上报周期
     * @param periodMs
     */
    void setReportPeriod(long periodMs);

    Reporter build();
}
