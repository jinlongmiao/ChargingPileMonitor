package simulator.dataItem;

import java.util.Random;
import java.util.UUID;
import simulator.dataItem.AllPeriodRealTimeData.ArresterStatus;
import simulator.dataItem.AllPeriodRealTimeData.ChargingModuleFault;
import simulator.dataItem.AllPeriodRealTimeData.DirectCurrentContactorFaultStatus;
import simulator.dataItem.AllPeriodRealTimeData.DirectCurrentContactorStatus;
import simulator.dataItem.AllPeriodRealTimeData.ElectronicLockStatus;
import simulator.dataItem.AllPeriodRealTimeData.InsulationFault;
import simulator.dataItem.AllPeriodRealTimeData.MaintainDoorStatus;
import simulator.dataItem.AllPeriodRealTimeData.StopButtonStatus;
import simulator.dataItem.AllPeriodRealTimeData.VehicleConnectGuideStatus;
import simulator.dataItem.AllPeriodRealTimeData.VehicleConnectingStatus;
import simulator.dataItem.AllPeriodRealTimeData.WorkingStatus;
import simulator.dataItem.ChargingBMSData.BatteryType;

/**
 * Created by zzt on 12/9/17.
 *
 * <h3></h3>
 */
public enum RealTimeDataEnum {
  ALL {
    @Override
    RealTimeData random() {
      AllPeriodRealTimeData data = new AllPeriodRealTimeData();
      data.setWorkingStatus(random.nextInt(WorkingStatus.values().length))
          .setMaintainDoorStatus(random.nextInt(MaintainDoorStatus.values().length))
          .setElectronicLockStatus(random.nextInt(ElectronicLockStatus.values().length))
          .setStopButtonStatus(random.nextInt(StopButtonStatus.values().length))
          .setVehicleConnectingStatus(random.nextInt(VehicleConnectingStatus.values().length))
          .setArresterStatus(random.nextInt(ArresterStatus.values().length))
          .setVehicleConnectGuideStatus(random.nextInt(VehicleConnectGuideStatus.values().length))
          .setDirectCurrentContactorStatus(
              random.nextInt(DirectCurrentContactorStatus.values().length))
          .setDirectCurrentContactorFaultStatus(
              random.nextInt(DirectCurrentContactorFaultStatus.values().length))
          .setChargingModuleFault(random.nextInt(ChargingModuleFault.values().length))
          .setInsulationFault(random.nextInt(InsulationFault.values().length))
          .setAcInputVoltageA(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setAcInputVoltageB(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setAcInputVoltageC(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setAcInputCurrentA(random.nextInt(currentMax - currentMin) + currentMin)
          .setAcInputCurrentB(random.nextInt(currentMax - currentMin) + currentMin)
          .setAcInputCurrentC(random.nextInt(currentMax - currentMin) + currentMin)
          .setVehicleGuideVoltage(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setBMSAuxiliaryVoltage(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setChargerProbeTemperature(random.nextInt(tempMax - tempMin) + tempMin);
      return data;
    }
  }, C_BMS {
    @Override
    RealTimeData random() {
      return new ChargingBMSData()
          .setBatteryVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setChargingVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setChargingCur(random.nextInt(currentMax - currentMin) + currentMin)
          .setBmsVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setBmsCur(random.nextInt(currentMax - currentMin) + currentMin)
          .setSingleMaxVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setSingleMinVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setTimeToCharge(random.nextInt(timeMax))
          .setVehSoc(random.nextDouble())
          .setBatteryType(random.nextInt(BatteryType.values().length))
          .setChargingSoc(random.nextDouble())
          .setVehVin(UUID.randomUUID().toString())
          .setChargingMaxVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setChargingMaxCur(random.nextInt(currentMax - currentMin) + currentMin);
    }
  }, C_PILE {
    @Override
    RealTimeData random() {
      return new ChargingPileData()
          .setOutputVol(random.nextInt(voltageMax - voltageMin) + voltageMin)
          .setOutpuCur(random.nextInt(currentMax - currentMin) + currentMin)
          .setPower(random.nextInt(powerMax))
          .setTime(random.nextInt(timeMax));
    }
  };

  static final int voltageMax = 220;
  static final int voltageMin = 110;
  static final int currentMax = 100;
  static final int currentMin = 200;
  static final int tempMax = 50;
  static final int tempMin = -10;
  static final int timeMax = 30;
  static final int powerMax = 300;

  Random random = new Random(12);

  abstract RealTimeData random();

}
