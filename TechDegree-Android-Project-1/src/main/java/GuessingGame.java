import java.io.Console;



public class GuessingGame {
  
   private static String typeOfItem;

    public static void main(String[] args) {

      
      
      int maxItemCount = 0;
      Console console = System.console();
      
      if (args.length != 2){
        System.out.printf("Two arguments must be entered.\nExiting Application.\n");
        System.exit(0);
      }
      try{
        typeOfItem = args[0];
        if(typeOfItem.matches(".*\\d.*")){
          throw new IllegalArgumentException("The first argument must be a word containing only letters.\n");
        }
      }catch(IllegalArgumentException i){
        System.out.printf(i.getMessage());
        System.exit(0);
      }
      try{
        maxItemCount = Integer.parseInt(args[1]);
        if (maxItemCount <= 0){
          System.out.printf("The maximum fill amount must be geater than zero.\nExiting Application.\n");
          System.exit(0);
        }
      }catch(NumberFormatException j){
        System.out.printf("The second argument must be a number.\nExiting Application.\n");
        System.exit(0);
      }
      
      typeOfItem = args[0];
 

      String livesAsString;
      int livesAsInt = 0;
      boolean validLives = false;
      int i = 0;
      while(!validLives){
        try{
          livesAsString = console.readLine("How many lives? ");
          livesAsInt = Integer.parseInt(livesAsString);
          validLives = true;
        }catch(NumberFormatException iae){
          console.printf("A number must be entered./n");
      }
      while(i < livesAsInt){
        Jar jar = new Jar(typeOfItem, maxItemCount);
        Prompter promptor = new Prompter(jar);
        promptor.play();

        i++;
      }
     }
    }
     

    public static String getTypeOfItem(){
      String mTypeOfItem = typeOfItem;
      return mTypeOfItem;
    
      
    }
}
