public class Game {
  private String mItemName;
  private int mMaximumNumberOfItems;
  private String mUserName;
  private int mRandomNumber;
  private int mLives;
  private int mHighScore;


  public Game(String items, int number, String user, int randomNumber, int lives, int highScore){
    mItemName = items;
    mMaximumNumberOfItems = number;
    mUserName = user;
    mRandomNumber = randomNumber;
    mLives = lives;
    mHighScore = highScore;
            
  }
  
  public void setItemName(String name) {
    mItemName = name;
  }
  public String getItemName() {
    return mItemName;
  }  
  
  public void setMaximumNumberOfItems(int number) {
    mMaximumNumberOfItems = number;
  }
  public int getMaximumNumberOfItems() {
    return mMaximumNumberOfItems;
  }
  
  public void setUserName(String user) {
    mUserName = user;  
  }
  public String getUserName() {
    return mUserName;
  }
  
  public void setRandomNumber(int randomNumber) {
    mRandomNumber = randomNumber;  
  }
  public int getRandomNumber() {
    return mRandomNumber;
  }
  
  public void setLives(int lives) {
    mLives = lives;  
  }
  public int getLives() {
    return mLives;
  }
  
  public void setHighScore(int highScore) {
    mHighScore = highScore;
  }
  public int getHighScore() {
    return mHighScore;
  }  
  
  public void deductLives(int livesDeducted) {
    if((mLives - livesDeducted) <= 0) {
      System.exit(0);
    } else {
    mLives -= livesDeducted;
    }
  }
  public boolean maximumItemsSelected(int guessMade) {
    if(mMaximumNumberOfItems < guessMade){
    throw new IllegalArgumentException("Invalid guess! Exceeds setup parameters");
    }
    return true;
  }
  
  //Testing the answer guessed in prompter
  public int testGuess(int guessMade) {
    if (guessMade == mRandomNumber){
      return 1;
    } else if (guessMade > mRandomNumber && guessMade <= mMaximumNumberOfItems){
      return 2;
    } else if(guessMade < mRandomNumber && guessMade <= mMaximumNumberOfItems){
      return 3;
    } 
    return 4;
  }
  //Calculate and replace high score with new best score if made  
  public int highScoreCalculation(int score) {
    if (score < mHighScore){
     mHighScore = score;
    }else {
    
    }return 200;
      
  }
  
 
}