package simulator;

import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface RealTimeDataReporter {

    /**
     *
     * @param out 网络传输
     */
    void setOutputStream(Object out);

    void reportAllPeriodRealTimeData(AllPeriodRealTimeData data);

    void reportOutputData(ChargingOutputData outputData);

    void reportBMSData(BMSData bmsData);
}
