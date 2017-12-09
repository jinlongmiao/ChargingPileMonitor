package simulator.dataItem;

/**
 * 车辆动力电池总电压、充电电压测量值、充电电流测量值、BMS需求充电电压、BMS需求充电电流、单体电池最高电压、
 * 单体电池最低电压、单体最高温度、单体最低温度，剩余充电时间、当前车辆Soc；
 * 电池类型、开始充电Soc、车辆Vin码、最高允许充电电压、最大允许充电电流等；
 * Created by violetMoon on 2017/12/4.
 */
public class ChargingBMSData implements RealTimeData {

  enum BatteryType {
    NI_CD, NI_MH,Li_LON,LI_POLY,SEALED;
  }

  private int batteryVol;
  private int chargingVol;
  private int chargingCur;
  private int bmsVol;
  private int bmsCur;
  private int singleMaxVol;
  private int singleMinVol;
  private int singleMaxTemp = RealTimeDataEnum.tempMax;
  private int singleMinTemp = RealTimeDataEnum.tempMin;
  private int timeToCharge;
  private double vehSoc;
  private int batteryType;
  private double chargingSoc;
  private String vehVin;
  private int chargingMaxVol;
  private int chargingMaxCur;

  public ChargingBMSData setBatteryVol(int batteryVol) {
    this.batteryVol = batteryVol;
    return this;
  }

  public ChargingBMSData setChargingVol(int chargingVol) {
    this.chargingVol = chargingVol;
    return this;
  }

  public ChargingBMSData setChargingCur(int chargingCur) {
    this.chargingCur = chargingCur;
    return this;
  }

  public ChargingBMSData setBmsVol(int bmsVol) {
    this.bmsVol = bmsVol;
    return this;
  }

  public ChargingBMSData setBmsCur(int bmsCur) {
    this.bmsCur = bmsCur;
    return this;
  }

  public ChargingBMSData setSingleMaxVol(int singleMaxVol) {
    this.singleMaxVol = singleMaxVol;
    return this;
  }

  public ChargingBMSData setSingleMinVol(int singleMinVol) {
    this.singleMinVol = singleMinVol;
    return this;
  }

  public ChargingBMSData setSingleMaxTemp(int singleMaxTemp) {
    this.singleMaxTemp = singleMaxTemp;
    return this;
  }

  public ChargingBMSData setSingleMinTemp(int singleMinTemp) {
    this.singleMinTemp = singleMinTemp;
    return this;
  }

  public ChargingBMSData setTimeToCharge(int timeToCharge) {
    this.timeToCharge = timeToCharge;
    return this;
  }

  public ChargingBMSData setVehSoc(double vehSoc) {
    this.vehSoc = vehSoc;
    return this;
  }

  public ChargingBMSData setBatteryType(int batteryType) {
    this.batteryType = batteryType;
    return this;
  }

  public ChargingBMSData setChargingSoc(double chargingSoc) {
    this.chargingSoc = chargingSoc;
    return this;
  }

  public ChargingBMSData setVehVin(String vehVin) {
    this.vehVin = vehVin;
    return this;
  }

  public ChargingBMSData setChargingMaxVol(int chargingMaxVol) {
    this.chargingMaxVol = chargingMaxVol;
    return this;
  }

  public ChargingBMSData setChargingMaxCur(int chargingMaxCur) {
    this.chargingMaxCur = chargingMaxCur;
    return this;
  }

  public String getData() {
    return null;
  }
}
