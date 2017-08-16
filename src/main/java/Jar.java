import java.util.Random;

public class Jar{
  private static int mAnswer = 0;
  private static int maxItems;
  private static String mTypeofItem;
  
  Random random = new Random();
  
  private int mHits;
  private int mMisses;
  
  boolean isSolved = false;
  
  public Jar(String typeOfItem, int answer){
     mTypeofItem = typeOfItem;
     mAnswer = random.nextInt(answer) + 1;
     maxItems = answer;
         mMisses = 1;
  }
  
  private int validateGuess(int number){
    if(number > maxItems){
       throw new IllegalArgumentException
         (number + " is higher than the possible amount that can reasonably fit in a jar."); 
    }
    if (number < 0){
      throw new IllegalArgumentException
         ("A positive number must be entered."); 
    }
    if(number > mAnswer){
      System.out.printf("too high\n"); 
    }else if (number < mAnswer){
      System.out.printf("too low\n");
    }
    
    return number;   
  }
  
  public boolean applyGuess(int number){
    number = validateGuess(number);
    boolean isHit = false;
    if(mAnswer == number){
      isHit = true;
    }
    if(isHit){
     isSolved = isHit;
    }else{
      mMisses++;
    }
    return isHit;
  }
  
  public int getAnswer(){
    return maxItems;
  }
  
  public int getTries(){
    return mMisses;
  }
  
  public boolean isSolved(){
    return isSolved;
  }
}