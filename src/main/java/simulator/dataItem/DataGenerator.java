package simulator.dataItem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zzt on 12/8/17.
 *
 * <h3></h3>
 */
public class DataGenerator implements Runnable {

  private BlockingQueue<RealTimeData> queue;
  private Random random = new Random(12);

  public DataGenerator(BlockingQueue<RealTimeData> queue) {
    this.queue = queue;
  }

  public void run() {
    int dataType = random.nextInt(4);
    switch (dataType) {
      case 0:
        queue.add(new AllPeriodRealTimeData());
        break;

    }
  }
}
