package simulator.dataItem;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zzt on 12/8/17.
 *
 * <h3></h3>
 */
public class RecordGenerator implements Runnable {
  private BlockingQueue<PileRecord> record;

  public RecordGenerator(BlockingQueue<PileRecord> record) {
    this.record = record;
  }

  public void run() {

  }
}
