package simulator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import simulator.dataItem.*;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class RealTimeDataReporter implements Reporter {

  private OutputStream outputStream;
  private ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
  private BlockingQueue<RealTimeData> queue;
  private long periodMs;

  private RealTimeDataReporter(OutputStream outputStream,
      BlockingQueue<RealTimeData> queue, long periodMs) {
    this.outputStream = outputStream;
    this.queue = queue;
    this.periodMs = periodMs;
  }

  public void start() {
    service.scheduleAtFixedRate(() -> {
      try {
        outputStream.write(queue.take().getData().getBytes());
      } catch (InterruptedException | IOException e) {
        e.printStackTrace();
      }
    }, 0, periodMs, TimeUnit.MILLISECONDS);
  }

  public void stop() throws InterruptedException {
    service.awaitTermination(1, TimeUnit.SECONDS);
    service.shutdown();
  }

  class RealTimeDataReporterBuilder implements ReporterBuilder {

    private OutputStream outputStream;
    private BlockingQueue<RealTimeData> queue;
    private long periodMs;

    public ReporterBuilder setNetInterface(OutputStream out) {
      this.outputStream = outputStream;
      return this;
    }

    public ReporterBuilder setReportPeriod(long periodMs) {
      this.periodMs = periodMs;
      return this;
    }

    @Override
    public ReporterBuilder setQueue(BlockingQueue<RealTimeData> queue) {
      this.queue = queue;
      return this;
    }

    public RealTimeDataReporter build() {
      return new RealTimeDataReporter(outputStream, queue, periodMs);
    }
  }
}
