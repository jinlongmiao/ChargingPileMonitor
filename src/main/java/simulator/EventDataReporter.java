package simulator;

import simulator.dataItem.ChargingDealRecord;
import simulator.dataItem.EventRecord;
import simulator.dataItem.FaultAlarmRecord;
import simulator.dataItem.PileRecord;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface EventDataReporter extends Reporter{

    void reportRecord(PileRecord eventRecord);

}
