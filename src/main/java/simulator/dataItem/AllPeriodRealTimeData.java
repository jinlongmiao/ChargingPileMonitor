package simulator.dataItem;

/**
 * 工作状态、检修门状态、充电枪电子锁状态、急停按钮状态、车辆连接状态、避雷器状态、车辆连接引导状态等、直流输出接触器状态
 * 、充电模块故障、绝缘故障；交流输入电压、交流输入电流、车辆引导电压、BMS辅助电源电压、充电枪插头温度；
 * Created by violetMoon on 2017/12/4.
 */
public class AllPeriodRealTimeData implements RealTimeData {
    public enum WorkingStatus {
        IDLE(0), CHARGING(1), CHARGING_COMPLETE(2), FAILURE(255);

        private int value;
        WorkingStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum MaintainDoorStatus {
        CLOSE, OPEN
    }

    /**
     * 充电枪电子锁状态
     */
    public enum ElectronicLockStatus {
        UNLOCKED, LOCKED
    }

    /**
     * 急停按钮状态
     */
    public enum StopButtonStatus {
        REGULAR, FAILURE
    }

    /**
     * 车辆连接状态
     */
    public enum VehicleConnectingStatus {
        DISCONNECTED, CONNECTED
    }

    /**
     * 避雷器状态
     */
    public enum ArresterStatus {
        NORMAL, FAILURE
    }

    /**
     * 车辆连接导引状态
     */
    public enum VehicleConnectGuideStatus {
        NORMAL, FAILURE
    }

    /**
     * 直流输出接触器状态
     */
    public enum DirectCurrentContactorStatus {
        NORMAL, CLOSE
    }

    /**
     * 直流输出接触器故障状态
     */
    public enum DirectCurrentContactorFaultStatus {
        NORMAL, REFUSE, STICKY
    }

    /**
     * 充电模块故障
     */
    public enum ChargingModuleFault {
        NORMAL, FAILURE
    }

    /**
     * 绝缘故障
     */
    public enum InsulationFault {
        NORMAL, FAILURE
    }

    private int workingStatus;
    private int maintainDoorStatus;
    private int electronicLockStatus;
    private int stopButtonStatus;
    private int vehicleConnectingStatus;
    private int arresterStatus;
    private int vehicleConnectGuideStatus;
    private int directCurrentContactorStatus;
    private int directCurrentContactorFaultStatus;
    private int chargingModuleFault;
    private int insulationFault;

    //交流输入电压
    private int acInputVoltageA;
    private int acInputVoltageB;
    private int acInputVoltageC;

    //交流输入电流
    private int acInputCurrentA;
    private int acInputCurrentB;
    private int acInputCurrentC;

    //车辆引导电压
    private int vehicleGuideVoltage;
    //BMS辅助电源电压
    private int BMSAuxiliaryVoltage;
    //充电枪探头温度
    private int ChargerProbeTemperature;

    public AllPeriodRealTimeData setWorkingStatus(int workingStatus) {
        this.workingStatus = workingStatus;
        return this;
    }

    public AllPeriodRealTimeData setMaintainDoorStatus(int maintainDoorStatus) {
        this.maintainDoorStatus = maintainDoorStatus;
        return this;
    }

    public AllPeriodRealTimeData setElectronicLockStatus(int electronicLockStatus) {
        this.electronicLockStatus = electronicLockStatus;
        return this;
    }

    public AllPeriodRealTimeData setStopButtonStatus(int stopButtonStatus) {
        this.stopButtonStatus = stopButtonStatus;
        return this;
    }

    public AllPeriodRealTimeData setVehicleConnectingStatus(int vehicleConnectingStatus) {
        this.vehicleConnectingStatus = vehicleConnectingStatus;
        return this;
    }

    public AllPeriodRealTimeData setArresterStatus(int arresterStatus) {
        this.arresterStatus = arresterStatus;
        return this;
    }

    public AllPeriodRealTimeData setVehicleConnectGuideStatus(int vehicleConnectGuideStatus) {
        this.vehicleConnectGuideStatus = vehicleConnectGuideStatus;
        return this;
    }

    public AllPeriodRealTimeData setDirectCurrentContactorStatus(int directCurrentContactorStatus) {
        this.directCurrentContactorStatus = directCurrentContactorStatus;
        return this;
    }

    public AllPeriodRealTimeData setDirectCurrentContactorFaultStatus(
        int directCurrentContactorFaultStatus) {
        this.directCurrentContactorFaultStatus = directCurrentContactorFaultStatus;
        return this;
    }

    public AllPeriodRealTimeData setChargingModuleFault(int chargingModuleFault) {
        this.chargingModuleFault = chargingModuleFault;
        return this;
    }

    public AllPeriodRealTimeData setInsulationFault(int insulationFault) {
        this.insulationFault = insulationFault;
        return this;
    }

    public AllPeriodRealTimeData setAcInputVoltageA(int acInputVoltageA) {
        this.acInputVoltageA = acInputVoltageA;
        return this;
    }

    public AllPeriodRealTimeData setAcInputVoltageB(int acInputVoltageB) {
        this.acInputVoltageB = acInputVoltageB;
        return this;
    }

    public AllPeriodRealTimeData setAcInputVoltageC(int acInputVoltageC) {
        this.acInputVoltageC = acInputVoltageC;
        return this;
    }

    public AllPeriodRealTimeData setAcInputCurrentA(int acInputCurrentA) {
        this.acInputCurrentA = acInputCurrentA;
        return this;
    }

    public AllPeriodRealTimeData setAcInputCurrentB(int acInputCurrentB) {
        this.acInputCurrentB = acInputCurrentB;
        return this;
    }

    public AllPeriodRealTimeData setAcInputCurrentC(int acInputCurrentC) {
        this.acInputCurrentC = acInputCurrentC;
        return this;
    }

    public AllPeriodRealTimeData setVehicleGuideVoltage(int vehicleGuideVoltage) {
        this.vehicleGuideVoltage = vehicleGuideVoltage;
        return this;
    }

    public AllPeriodRealTimeData setBMSAuxiliaryVoltage(int BMSAuxiliaryVoltage) {
        this.BMSAuxiliaryVoltage = BMSAuxiliaryVoltage;
        return this;
    }

    public AllPeriodRealTimeData setChargerProbeTemperature(int chargerProbeTemperature) {
        ChargerProbeTemperature = chargerProbeTemperature;
        return this;
    }

    public String getData() {
        return null;
    }
}
