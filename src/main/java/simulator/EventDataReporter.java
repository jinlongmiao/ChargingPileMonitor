package simulator;

import simulator.dataItem.ChargingDealRecord;
import simulator.dataItem.EventRecord;
import simulator.dataItem.FaultAlarmRecord;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface EventDataReporter extends Reporter{

    /**
     *
     * @param out 记录数据网络传输接口
     */
    void setOutputStream(Object out);

    void reportEventRecord(EventRecord eventRecord);

    void reportFaultAlarmRecord(FaultAlarmRecord faultAlarmRecord);

    void reportChargingDealRecord(ChargingDealRecord chargingDealRecord);
}
