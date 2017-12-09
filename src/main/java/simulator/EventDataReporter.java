package simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import simulator.dataItem.RealTimeData;

/**
 * Created by violetMoon on 2017/12/6.
 */
public class EventDataReporter implements Reporter {

  private volatile boolean notEnd = true;
  private volatile boolean suc = false;
  private ExecutorService service = Executors.newFixedThreadPool(2);
  private OutputStream outputStream;
  private BufferedReader reader;
  private BlockingQueue<RealTimeData> queue;

  private EventDataReporter(OutputStream outputStream, InputStream inputStream,
      BlockingQueue<RealTimeData> queue) {
    this.outputStream = outputStream;
    this.reader = new BufferedReader(new InputStreamReader(inputStream));
    this.queue = queue;
  }

  public void start() {
    service.submit(() -> {
      while (notEnd) {
        try {
          outputStream.write(queue.take().getData().getBytes());
          while (!suc) {
            reader.wait();
          }
          suc = false;
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    service.submit(() -> {
      while (notEnd) {
        try {
          if (reader.readLine().equals("ok")) {
            suc = true;
            reader.notify();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  public void stop() throws IOException {
    notEnd = false;
    reader.close();
    outputStream.close();
  }

  class EventDataReporterBuilder implements ReporterBuilder {

    private OutputStream outputStream;
    private InputStream inputStream;
    private BlockingQueue<RealTimeData> queue;

    public ReporterBuilder setReportPeriod(long periodMs) {
      return this;
    }

    public EventDataReporterBuilder setNetInterface(OutputStream outputStream) {
      this.outputStream = outputStream;
      return this;
    }

    public EventDataReporterBuilder setNetInterface(InputStream inputStream) {
      this.inputStream = inputStream;
      return this;
    }

    public EventDataReporterBuilder setQueue(BlockingQueue<RealTimeData> queue) {
      this.queue = queue;
      return this;
    }

    public EventDataReporter build() {
      return new EventDataReporter(outputStream, inputStream, queue);
    }
  }
}
