package simulator;

import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class RealTimeDataReporter implements Reporter{

    public void start() {

    }

    public void stop() {

    }

    class RealTimeDataReporterBuilder implements ReporterBuilder {

        public void setNetInterface(Object out) {

        }

        public void setReportPeriod(double periodMs) {

        }

        public RealTimeDataReporter build() {
            return null;
        }
    }
}
