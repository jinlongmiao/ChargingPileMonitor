package simulator.dataItem;

/**
 * Created by violetMoon on 2017/12/4.
 * 开始充电时间、充电启动控制码、充电时间、充电电能、充电金额、车辆VIN码
 */
public class ChargingDealRecord implements PileRecord {

  private long startTime;
  private String chargingCode;
  private long chargingTime;
  private long charging;
  private double chargingMoney;
  private String vehVinCode;

  public ChargingDealRecord setStartTime(long startTime) {
    this.startTime = startTime;
    return this;
  }

  public ChargingDealRecord setChargingCode(String chargingCode) {
    this.chargingCode = chargingCode;
    return this;
  }

  public ChargingDealRecord setChargingTime(long chargingTime) {
    this.chargingTime = chargingTime;
    return this;
  }

  public ChargingDealRecord setCharging(long charging) {
    this.charging = charging;
    return this;
  }

  public ChargingDealRecord setChargingMoney(double chargingMoney) {
    this.chargingMoney = chargingMoney;
    return this;
  }

  public ChargingDealRecord setVehVinCode(String vehVinCode) {
    this.vehVinCode = vehVinCode;
    return this;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return startTime + chargingTime;
  }

  public String getRecord() {
    return null;
  }
}
