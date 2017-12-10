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
          .setAcInputVoltageA(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setAcInputVoltageB(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setAcInputVoltageC(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setAcInputCurrentA(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setAcInputCurrentB(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setAcInputCurrentC(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setVehicleGuideVoltage(random.nextInt(
              Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setBMSAuxiliaryVoltage(random.nextInt(
              Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setChargerProbeTemperature(random.nextInt(Const.tempMax - Const.tempMin) + Const.tempMin);
      return data;
    }
  }, C_BMS {
    @Override
    RealTimeData random() {
      return new ChargingBMSData()
          .setBatteryVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setChargingVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setChargingCur(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setBmsVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setBmsCur(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setSingleMaxVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setSingleMinVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setTimeToCharge(random.nextInt(Const.timeMax))
          .setVehSoc(random.nextDouble())
          .setBatteryType(random.nextInt(BatteryType.values().length))
          .setChargingSoc(random.nextDouble())
          .setVehVin(UUID.randomUUID().toString())
          .setChargingMaxVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setChargingMaxCur(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin);
    }
  }, C_PILE {
    @Override
    RealTimeData random() {
      return new ChargingPileData()
          .setOutputVol(random.nextInt(Const.voltageMax - Const.voltageMin) + Const.voltageMin)
          .setOutpuCur(random.nextInt(Const.currentMax - Const.currentMin) + Const.currentMin)
          .setPower(random.nextInt(Const.powerMax))
          .setTime(random.nextInt(Const.timeMax));
    }
  };

  Random random = new Random(12);

  abstract RealTimeData random();

}
