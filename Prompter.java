import java.io.Console;
import java.util.Random;

public class Prompter {
Console console = System.console();
  
  private Game mGame;
  
  public Prompter(Game game) {
    mGame = game;
  }
  
  
  public void startGame() {
    if ((mGame.getMaximumNumberOfItems() ==0) || (mGame.getLives() == 4)){
        displayAdminSection();
        
    }
        mGame.deductLives(1);
        playerInput();
        startGuessing();

  }
  
  public void displayAdminSection() {
    console.printf("-----------ADMIN--SETUP--------------- \n======================================\n");
    String NameOfItemsInJar = console.readLine("Name of items that would be in the jar: ");
    String maxItemsInJar = console.readLine("Maximum number of %s's in the jar: ",NameOfItemsInJar);
    int maxItemsStringToInt = Integer.parseInt(maxItemsInJar); 
    mGame.setItemName(NameOfItemsInJar);
    mGame.setMaximumNumberOfItems(maxItemsStringToInt);
   
  }
  
  
  public void playerInput() {
    Random random = new Random();
    int maxNumberAllowed = mGame.getMaximumNumberOfItems();
    int someNumber = random.nextInt(maxNumberAllowed);
      if (someNumber ==0){
        someNumber++;
      } 
      mGame.setRandomNumber(someNumber);
    
    System.out.printf("The random number is %d.%n", someNumber);
    console.printf("\n\n-----PLAYER-----\n================\n\n");
     if (mGame.getUserName() == "") {
      String userName = console.readLine("Please enter your Name: ");
      mGame.setUserName(userName);
      console.printf("\n%s, your goal is to guess how many %s(s) there are in the jar. Your guess should be between 1 and %s.\n",userName,mGame.getItemName(),mGame.getMaximumNumberOfItems());
    }
    

    System.out.println(mGame.getLives() + " Games remaining. \nWhen you're ready, hit ENTER to continue...");
      try {
        System.in.read();
      }  
        catch(Exception e)
        {}  
  
  }
  
  public void startGuessing() {
    boolean validGuess = false;
    int attempts = 0;
    while(!validGuess){
      String guess = console.readLine("Guess: ");
      int guessToInt = Integer.parseInt(guess);
      validGuess = guessToInt == mGame.getRandomNumber();
      attempts++;
      try {
        mGame.maximumItemsSelected(guessToInt);
      } catch (IllegalArgumentException iae){
        console.printf("%s. Please try again. \n", iae.getMessage());
        attempts--;
      }

      if (mGame.testGuess(guessToInt) == 1){
        console.printf("\nCongrats! %s %s(s) in the Jar! You got it in %d attempt(s) \n\n",mGame.getRandomNumber(),mGame.getItemName(), attempts);
      } else if (mGame.testGuess(guessToInt) == 2){
        console.printf("To high, try again \n");
      } else if (mGame.testGuess(guessToInt) == 3)
          console.printf("To low, try again \n");
      }        
       
    mGame.highScoreCalculation(attempts);
    console.printf("High score: %s -- %s \n",mGame.getHighScore(),mGame.getUserName());
    startGame();
         
  }
  

  
  

  
  
  
}