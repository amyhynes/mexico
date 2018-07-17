// Amy Hynes, 260716296
// a program that simulates a game of Mexico
public class Mexico {
  public static void main(String[] args) {
    // converting command line inputs to doubles
    double buyIn = Double.parseDouble(args[0]);
    double bet = Double.parseDouble(args[1]);
    playMexico(buyIn, bet);
  }
  
  // a method that simulates the roll of a six-sided dice
  public static int diceRoll() {
    int roll = (int) (1 + Math.random() * 6);
    return roll;
  }
  
  // a method that takes two dice rolls and determines a player's score
  // the higher number rolled is always the first number in the score
  public static int getScore(int roll1, int roll2) { 
    if (roll1 >= roll2) {
      int score = Integer.parseInt(roll1 + "" + roll2);
      return score;
    } else {
      int score = Integer.parseInt(roll2 + "" + roll1);
      return score;
    }
  }
  
  // a method that simulates one round of Mexico
  // this method has a player roll the dice twice and determines their score
  public static int playOneRound(String name) {
    int roll1 = diceRoll();
    int roll2 = diceRoll();
    int score = getScore(roll1, roll2);
    if (name == "Giulia") {
      System.out.println("Giulia rolled: " + roll1 + " " + roll2);
      System.out.println("Giulia's score is: " + score);
      return score;
    } else if (name == "David") {
      System.out.println("David rolled: " + roll1 + " " + roll2);
      System.out.println("David's score is: " + score);
      return score;
    } else {
      return 0;
    }
  }
  
  // a method that determines who wins one round
  // this method implements the rules of Mexico including the 21 rule and doubles
  public static String getWinner(int giulia, int david) {
    if (giulia == david) {
      return "tie";
    } else if (giulia == 21) {
      return "Giulia";
    } else if (david == 21) {
      return "David";
    } else if (giulia == 66) {
      return "Giulia";
    } else if (david == 66) {
      return "David";
    } else if (giulia == 55) {
      return "Giulia";
    } else if (david == 55) {
      return "David";
    } else if (giulia == 44) {
      return "Giulia";
    } else if (david == 44) {
      return "David";
    } else if (giulia == 33) {
      return "Giulia";
    } else if (david == 33) {
      return "David";
    } else if (giulia == 22) {
      return "Giulia";
    } else if (david == 22) {
      return "David";
    } else if (giulia == 11) {
      return "Giulia";
    } else if (david == 11) {
      return "David";
    } else if (giulia > david) {
      return "Giulia";
    } else if (david > giulia) {
      return "David";
    } else {
      return "";
    } 
  }
  
  // a method that checks if a player is eligible to play a round
  // in order to be eligible the buy in must be a positive multiple of the bet
  public static boolean canPlay(double buyIn, double bet) {
    if (buyIn >= bet && buyIn % bet == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  // a method that simulates a game of Mexico
  public static void playMexico(double buyIn, double bet) {
    // if there isn't enough money to play the game, this if statement will stop the game
    if (canPlay(buyIn, bet) == false) {
      System.out.println("Insufficient funds. The game cannot be played.");
      return;
    } else {
      int round = 1;
      // these doubles track how much money David and Giulia have. They both start with the buy in
      double davidFunds = buyIn;
      double giuliaFunds = buyIn;
      // if either player runs out of money, the game will stop here and jump to print the winner
      while (canPlay(davidFunds, bet) == true && canPlay(giuliaFunds, bet) == true) {
        System.out.println("Round " + round);
        System.out.println("");
        // this string saves who won the game
        String winner = (getWinner(playOneRound("Giulia"), playOneRound("David")));
        round++;
        
        if (winner == "tie") {
          System.out.println("It's a tie. Roll again!");
          System.out.println("");
        } else {
          System.out.println(winner + " wins this round");
          System.out.println("");
          
          // this if statement updates the funds of the person who lost the round
          if (winner == "Giulia") {
            davidFunds = davidFunds - bet;
          } else if (winner == "David") {
            giuliaFunds = giuliaFunds - bet; 
          }
        }
      }
      
      // when someone has no money left, the game is over and the program prints the winner
      if (giuliaFunds == 0.0) {
        System.out.println("David won the game!");
        
      } else if (davidFunds == 0.0) {
        System.out.println("Giulia won the game!");
        
      } else {
        System.out.println("");
      }
    }
  }
}







