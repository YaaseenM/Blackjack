import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           // Establish sources.
        P1Random rand = new P1Random();

        int playerCardValue;                                // Define most essential variable in the while statement.
        int dealerHand;
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        int totalGamesPlayed = 0;
        int gameNumber = 1;
        int option = 1;
        int currentHand = 0;

        boolean continueGame = true;                        // continueGame is used to start the game while it is true.
        while (continueGame) {
            if (currentHand == 0) {
                System.out.println("START GAME #" + gameNumber);
            }
            if (option == 1) {                                      // This branch of if is used to increase player card and whether they bust.
                playerCardValue = rand.nextInt(13) + 1;
                System.out.println();
                switch (playerCardValue) {                          // Face cards have different cases to normal number cards.
                    case 1:
                        System.out.println("Your card is a ACE!");      // Ace is equal to 1.
                        break;
                    case 11:
                        System.out.println("Your card is a JACK!");         // All face cards are equal to 10.
                        playerCardValue = 10;
                        break;
                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        playerCardValue = 10;
                        break;
                    case 13:
                        System.out.println("Your card is a KING!");
                        playerCardValue = 10;
                        break;
                    default:                                                                // Regular number cards
                        System.out.println("Your card is a " + playerCardValue + "!");
                        break;
                }
                currentHand = currentHand + playerCardValue;                    // currentHand as the sum of all drawn card's in the current game.
                if (currentHand > 21) {                                         // Determines if the player has bust, blackjack, or can pick a card.
                    System.out.println("Your hand is: " + currentHand);
                    System.out.println();
                    System.out.println("You exceeded 21! You lose.");
                    totalGamesPlayed++;
                    dealerWins++;
                    gameNumber++;
                    currentHand = 0;
                    System.out.println();
                } else if (currentHand == 21) {
                    System.out.println("Your hand is: " + currentHand);
                    System.out.println();
                    System.out.println("BLACKJACK! You win!");
                    gameNumber++;
                    totalGamesPlayed++;
                    playerWins++;
                    currentHand = 0;
                    System.out.println();

                } else {                                                    // If the player did not get bust or get blackjack, then they will have to choose one of the options.
                    System.out.println("Your hand is: " + currentHand);
                    System.out.println();
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    option = scanner.nextInt();
                }

            } else if (option == 2) {                                      // Hold hand, meaning it is the dealer's turn to pick a value from 16 to 26
                dealerHand = rand.nextInt(11) + 16;
                System.out.println();
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + currentHand);
                if (dealerHand > currentHand && dealerHand <= 21) {        // 1st Checks if dealer wins
                    System.out.println();
                    System.out.println("Dealer wins!");
                    totalGamesPlayed++;
                    dealerWins++;
                    gameNumber++;
                    currentHand = 0;
                    option = 1;
                    System.out.println();
                } else if (dealerHand < currentHand || dealerHand > 21) {       // Then Checks if you win
                    System.out.println();
                    System.out.println("You win!");
                    totalGamesPlayed++;
                    playerWins++;
                    gameNumber++;
                    currentHand = 0;
                    option = 1;
                    System.out.println();
                } else if (dealerHand == currentHand) {                     // Finally, checks if player and dealer ties
                    System.out.println();
                    System.out.println("It's a tie! No one wins!");
                    totalGamesPlayed++;
                    gameNumber++;
                    tieGames++;
                    currentHand = 0;
                    option = 1;
                    System.out.println();
                }

            } else if (option == 3) {                                       // Display statistics of the game
                System.out.println();
                System.out.println("Number of Player wins: " + playerWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + tieGames);
                System.out.println("Total # of games played is: " + totalGamesPlayed);
                if (totalGamesPlayed > 0) {                                                 // This if statement is used so 0/0 does not occur for percentPlayerWins
                    double percentPlayerWins = ((100 * playerWins) / totalGamesPlayed);
                    System.out.println("Percentage of Player wins: " + percentPlayerWins + "%");
                } else {
                    System.out.println("Percent of Player wins: 0.0%");
                }
                System.out.println();                                   // After displaying the statistics, we continue the game.
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

            } else if (option == 4) {                               // Player can end the game with option four by ending the loop.
                continueGame = false;
            } else {                                                // If the option is any number other than [1,4], then it will remind the player to pick the valid options.
                System.out.println();
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println();
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
            }
        }
    }
}

