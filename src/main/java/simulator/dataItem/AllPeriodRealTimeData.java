package simulator.dataItem;

/**
 * 工作状态、检修门状态、充电枪电子锁状态、急停按钮状态、车辆连接状态、避雷器状态、车辆连接引导状态等、直流输出接触器状态
 * 、充电模块故障、绝缘故障；交流输入电压、交流输入电流、车辆引导电压、BMS辅助电源电压、充电枪插头温度；
 * Created by violetMoon on 2017/12/4.
 */
public class AllPeriodRealTimeData {
//    public enum WorkingStatus {
//        IDLE(0), CHARGING(1), CHARGING_COMPLETE(2), FAILURE(255);
//
//        private int value;
//        WorkingStatus(int value) {
//            this.value = value;
//        }
//
//        public int getValue() {
//            return value;
//        }
//    }
//
//    public enum MaintainceDoorStatus {
//        CLOSE, OPEN
//    }
//
//    /**
//     * 充电枪电子锁状态
//     */
//    public enum ElectronicLockStatus {
//        UNLOCKED, LOCKED
//    }
//
//    /**
//     * 急停按钮状态
//     */
//    public enum StopButtonStatus {
//        REGULAR, FAILURE
//    }
//
//    /**
//     * 车辆连接状态
//     */
//    public enum VehicleConnectingStatus {
//        DISCONNECTED, CONNECTED
//    }
//
//    /**
//     * 避雷器状态
//     */
//    public enum ArresterStatus {
//        NORMAL, FAILURE
//    }
//
//    /**
//     * 车辆连接导引状态
//     */
//    public enum VehicleConnectGuideStatus {
//        NORMAL, FAILURE
//    }
//
//    /**
//     * 直流输出接触器状态
//     */
//    public enum DirectCurrentContactorStatus {
//        NORMAL, CLOSE
//    }

//    /**
//     * 直流输出接触器故障状态
//     */
//    public enum DirectCurrentContactorFaultStatus {
//        NORMAL, REFUSE, STICKY
//    }
//
//    /**
//     * 充电模块故障
//     */
//    public enum ChargingModuleFault {
//        NORMAL, FAILURE
//    }
//
//    /**
//     * 绝缘故障
//     */
//    public enum InsulationFault {
//        NORMAL, FAILURE
//    }
//
    public int workingStatus;
    public int maintainceDoorStatus;
    public int electronicLockStatus;
    public int stopButtonStatus;
    public int vehicleConnectingStatus;
    public int arresterStatus;
    public int vehicleConnectGuideStatus;
    public int directCurrentContactorStatus;
    public int directCurrentContactorFaultStatus;
    public int chargingModuleFault;
    public int insulationFault;

    //交流输入电压
    public int acInputVoltageA;
    public int acInputVoltageB;
    public int acInputVoltageC;

    //交流输入电流
    public int acInputCurrentA;
    public int acInputCurrentB;
    public int acInputCurrentC;

    //车辆引导电压
    public int vehicleGuideVoltage;
    //BMS辅助电源电压
    public int BMSAuxiliaryVoltage;
    //充电枪探头温度
    public int ChargerProbeTemperature;
}
