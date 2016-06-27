public class Jar {

  //All sent to prompter and game logic class where default values are replaced
  public static void main(String[] args) {
    Game game = new Game ("",0,"",0,4,200);
    Prompter prompter = new Prompter(game);
    prompter.startGame();
   
       
  }
}