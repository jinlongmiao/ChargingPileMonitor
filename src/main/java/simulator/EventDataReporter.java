package simulator;

import java.io.OutputStream;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class EventDataReporter implements Reporter{

    public void start() {

    }

    public void stop() {

    }

    class EventDataReporterBuilder implements ReporterBuilder {

        public void setNetInterface(OutputStream out) {

        }

        public void setReportPeriod(long periodMs) {

        }

        public EventDataReporter build() {
            return null;
        }
    }
}
