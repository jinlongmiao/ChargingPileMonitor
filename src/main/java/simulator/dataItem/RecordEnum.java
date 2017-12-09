package simulator.dataItem;

/**
 * Created by zzt on 12/9/17.
 *
 * <h3></h3>
 */
public enum RecordEnum {
  DEAL {
    @Override
    PileRecord random() {
      return null;
    }
  },EVENT {
    @Override
    PileRecord random() {
      return null;
    }
  },ALARM {
    @Override
    PileRecord random() {
      return null;
    }
  };
  abstract PileRecord random();

}
