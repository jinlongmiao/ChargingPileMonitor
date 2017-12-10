package simulator.dataItem;

/**
 * Created by violetMoon on 2017/12/4.
 * 故障告警发生/恢复时间、故障告警类型。主要包括：绝缘故障、模块故障、避雷器故障、急停故障、车辆引导故障
 */
public class FaultAlarmRecord implements PileRecord {

  enum AlarmType {
    ISOLATION, MODULE, ARRESTER,CRASH_STOP,GUIDE
  }
  private long alarmTime;
  private long recoverTime;
  private AlarmType alarmType;

  public FaultAlarmRecord setAlarmTime(long alarmTime) {
    this.alarmTime = alarmTime;
    return this;
  }

  public FaultAlarmRecord setRecoverTime(long recoverTime) {
    this.recoverTime = recoverTime;
    return this;
  }

  public FaultAlarmRecord setAlarmType(int alarmType) {
    this.alarmType = AlarmType.values()[alarmType];
    return this;
  }

  public String getRecord() {
    return null;
  }
}
