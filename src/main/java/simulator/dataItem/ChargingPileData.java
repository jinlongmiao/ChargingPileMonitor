package simulator.dataItem;

/**
 * 充电过程充电桩输出数据：
 * 充电机输出电压、充电机输出电流、充电模块（AC/DC）最高温度、充电电量（kWh）、充电时间；
 *
 * Created by violetMoon on 2017/12/4.
 */
public class ChargingPileData implements RealTimeData {

  private int outputVol;
  private int outputCur;
  private int acMaxTemp = Const.tempMax;
  private int power;
  private int time;

  public ChargingPileData setOutputVol(int outputVol) {
    this.outputVol = outputVol;
    return this;
  }

  public ChargingPileData setOutpuCur(int outpuCur) {
    this.outputCur = outpuCur;
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

  public int getOutputVol() {
    return outputVol;
  }

  public int getOutputCur() {
    return outputCur;
  }

  public void setOutputCur(int outputCur) {
    this.outputCur = outputCur;
  }

  public int getAcMaxTemp() {
    return acMaxTemp;
  }

  public int getPower() {
    return power;
  }

  public int getTime() {
    return time;
  }
  public String getData() {
    return null;
  }
}
