package simulator;

import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface RealTimeDataReporter {

    /**
     *
     * @param out 实时数据网络传输接口
     */
    void setOutputStream(Object out);

    void reportAllPeriodRealTimeData(AllPeriodRealTimeData data);

    void reportOutputData(ChargingOutputData outputData);

    void reportBMSData(ChargingBMSData bmsData);
}
