package simulator.dataItem;

/**
 * 充电过程充电桩输出数据：
 * 充电机输出电压、充电机输出电流、充电模块（AC/DC）最高温度、充电电量（kWh）、充电时间；
 *
 * Created by violetMoon on 2017/12/4.
 */
public class ChargingPileData implements RealTimeData {

  private int outputVol;
  private int outpuCur;
  private int acMaxTemp = RealTimeDataEnum.tempMax;
  private int power;
  private int time;

  public ChargingPileData setOutputVol(int outputVol) {
    this.outputVol = outputVol;
    return this;
  }

  public ChargingPileData setOutpuCur(int outpuCur) {
    this.outpuCur = outpuCur;
    return this;
  }

  public ChargingPileData setAcMaxTemp(int acMaxTemp) {
    this.acMaxTemp = acMaxTemp;
    return this;
  }

  public ChargingPileData setPower(int power) {
    this.power = power;
    return this;
  }

  public ChargingPileData setTime(int time) {
    this.time = time;
    return this;
  }

  public String getData() {
    return null;
  }
}
