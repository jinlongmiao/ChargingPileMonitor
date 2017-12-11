package simulator.dataItem;

/**
 * Created by violetMoon on 2017/12/4.
 * 事件发生时间、事件类型:启动充电、停止充电、修改参数
 */
public class EventRecord implements PileRecord{

  public enum EventType {
    START_CHARGING,STOP_CHARGING,CONFIG
  }
  private long time;
  private EventType type;

  public EventRecord(long time, EventType type) {
    this.time = time;
    this.type = type;
  }

  public String getRecord() {
    return null;
  }
}
