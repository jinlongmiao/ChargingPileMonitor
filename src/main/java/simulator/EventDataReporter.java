package simulator;

import simulator.dataItem.ChargingDealRecord;
import simulator.dataItem.EventRecord;
import simulator.dataItem.FaultAlarmRecord;
import simulator.dataItem.PileRecord;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class EventDataReporter implements Reporter{

    public void start() {

    }

    public void stop() {

    }

    class EventDataReporterBuilder implements ReporterBuilder {

        public void setNetInterface(Object out) {

        }

        public void setReportPeriod(double periodMs) {

        }

        public EventDataReporter build() {
            return null;
        }
    }
}
