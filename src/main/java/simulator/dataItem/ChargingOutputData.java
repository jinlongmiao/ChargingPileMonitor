package simulator.dataItem;

/**
 * 充电过程充电桩输出数据
 * Created by violetMoon on 2017/12/6.
 */
public class ChargingOutputData implements RealTimeData {

    public int voltage;
    public int current;
    public double moduleMaxTemperature; //AC/DC module
    public int chargingVolume; //kWH
    public int chargingTimeMs; //ms

    public String getData() {
        return null;
    }
}
