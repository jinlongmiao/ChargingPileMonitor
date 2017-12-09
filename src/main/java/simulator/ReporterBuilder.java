package simulator;

import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import simulator.dataItem.RealTimeData;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface ReporterBuilder {

    /**
     *
     * @param out
     */
    ReporterBuilder setNetInterface(OutputStream out);

    /**
     * 设置上报周期
     * @param periodMs
     */
    ReporterBuilder setReportPeriod(long periodMs);

    ReporterBuilder setQueue(BlockingQueue<RealTimeData> queue);

    Reporter build();
}
