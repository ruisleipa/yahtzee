import java.util.Observable;
import java.util.Random;

public class DiceModel extends Observable {

  private static final int dieLowerBound = 1;
  private static final int dieUpperBound = 6;
  private static final int rollsPerTurn = 3;
  private static final int diceCount = 5;

  private DieValues dice;
  private int rolledTimes;
  private boolean locked[];
  private  Random rand = new Random(4);

  public DiceModel(

  public int getDieCount(){
    return diceCount;
  }

  public DieValues getDieValues(){
    return dice;
  }

  public boolean canDiceBeLocked(){
    return ((rollsPerTurn - rolledTimes) > 0);
  }

  public void setDieLock(int i, boolean state){
    locked[i] = state;
  }

  public void roll(){
    int i = 0;
    while (i < diceCount){
      if (!locked[i]){
        dice.values[i] = rand.nextInt(dieUpperBound) + dieLowerBound;
      }
      i++;
    }
  }

  public class DieValues {

    private int values[];

    private DieValues(int count){
      values = new int[count];
    }
  }
}
