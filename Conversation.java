
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Conversation implements Chatbot {

  // Attributes 
private int numRounds;
private ArrayList<String> printTranscript;
private String[] basicResponses = {"Mhhm", "Tell me more.", "Interesting...", "I see.", "Bye!"};
  /**
   * Constructor 
   */
  Conversation() {
    this.printTranscript = new ArrayList<>();
  
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input  = new Scanner(System.in);

    //Asks for number of rounds
    System.out.print("Hello! How many rounds would you like to chat?");
    //scans for number of rounds
    this.numRounds = input.nextInt();
    input.nextLine();

    //Starts conversation
    System.out.println("Let's chat!");
    printTranscript.add("Let's chat!");

    //Conversation loop 
    for (int i = 0; i < this.numRounds; i++){
        //Asks for user input
        String userInput = input.nextLine();
        printTranscript.add(userInput);

        //Responds to user input
        String botresponds = respond(userInput);
        System.out.println(botresponds);
        printTranscript.add(botresponds);
    }
    System.out.println("Bye!");
    printTranscript.add("Bye!");

    input.close();

  }

  

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\nTranscript:");
    for (String line : this.printTranscript) {
      System.out.println(line);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    //Mirrored responses
    String[] words = inputString.split(" ");
    HashMap<String, String> mirrorWords = new HashMap<>();
    mirrorWords.put("I", "you");
    mirrorWords.put("me", "you");
    mirrorWords.put("am", "are");
    mirrorWords.put("you", "I");
    mirrorWords.put("my", "your");
    mirrorWords.put("your", "my");

    boolean mirrored = false;
    // //Mirrored response
    // String returnString = ""; 
    // return returnString; 
    for (int i = 0; i < words.length; i++) {
        if (mirrorWords.containsKey(words[i])) {
            words[i] = mirrorWords.get(words[i]);
            mirrored = true;
        }
    }
    //this for sending the basic responses to the user 
    if (mirrored) {
        return String.join(" ", words) + "?";
    } else {
        return basicResponses[(int) (Math.random() * basicResponses.length)];
    }
}

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}

