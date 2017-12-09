package simulator;

import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public interface RealTimeDataReporter extends Reporter{

    void reportData(ChargingData Data);
}
