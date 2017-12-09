package simulator.dataItem;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zzt on 12/8/17.
 *
 * <h3></h3>
 */
public class DataGenerator implements Runnable {
  private BlockingQueue<ChargingData> data;

  public DataGenerator(BlockingQueue<ChargingData> data) {
    this.data = data;
  }

  public void run() {

  }
}
