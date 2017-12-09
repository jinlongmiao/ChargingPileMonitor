package simulator.dataItem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

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
      int dataType = random.nextInt(values.length);
      queue.add(values[dataType].random());
    }
  }
}
