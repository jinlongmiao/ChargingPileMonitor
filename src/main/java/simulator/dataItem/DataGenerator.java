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
    while (true) {
      RealTimeDataEnum[] values = RealTimeDataEnum.values();
      int dataType = random.nextInt(values.length);
      queue.add(values[dataType].random());
    }
  }
}
