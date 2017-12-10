package simulator.dataItem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import simulator.dataItem.EventRecord.EventType;

/**
 * Created by zzt on 12/8/17.
 *
 * <h3></h3>
 */
public class RecordGenerator implements Runnable {
  private BlockingQueue<PileRecord> queue;
  private Random random = new Random(12);

  public RecordGenerator(BlockingQueue<PileRecord> queue) {
    this.queue = queue;
  }

  public void run() {
    while (true) {
      RecordEnum[] values = RecordEnum.values();
      // except the event record
      int dataType = random.nextInt(values.length-1);
      PileRecord random = values[dataType].random();
      queue.add(random);
      if (dataType == RecordEnum.DEAL.ordinal()) {
        queue.add(new EventRecord(((ChargingDealRecord) random).getStartTime(), EventType.START_CHARGING));
        queue.add(new EventRecord(((ChargingDealRecord) random).getEndTime(), EventType.STOP_CHARGING));
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
