package simulator.dataItem;

import static simulator.dataItem.Const.currentMax;
import static simulator.dataItem.Const.currentMin;
import static simulator.dataItem.Const.money;
import static simulator.dataItem.Const.voltageMax;
import static simulator.dataItem.Const.voltageMin;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import simulator.dataItem.FaultAlarmRecord.AlarmType;

/**
 * Created by zzt on 12/9/17.
 *
 * <h3></h3>
 */
public enum RecordEnum {
  DEAL {
    @Override
    PileRecord random() {
      long now = new Date().getTime();
      int cost = random.nextInt(30 * 60) * 1000;
      long c = (random.nextInt(voltageMax - voltageMin) + voltageMin)
          * random.nextInt(currentMax - currentMin) + currentMin;
      return new ChargingDealRecord()
          .setStartTime(now - cost)
          .setChargingCode(UUID.randomUUID().toString())
          .setChargingTime(cost)
          .setCharging(c)
          .setChargingMoney(money * c)
          .setVehVinCode(UUID.randomUUID().toString())
          ;
    }
  }, ALARM {
    @Override
    PileRecord random() {
      long now = new Date().getTime();
      int cost = random.nextInt(30 * 60) * 1000;
      return new FaultAlarmRecord()
          .setAlarmTime(now-cost)
          .setRecoverTime(now)
          .setAlarmType(random.nextInt(AlarmType.values().length));
    }
  }, EVENT {
    @Override
    PileRecord random() {
      throw new UnsupportedOperationException();
    }
  };

  Random random = new Random(12);

  abstract PileRecord random();

}
