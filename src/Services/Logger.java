package Services;

import java.util.Scanner;
import java.util.regex.*;
import java.util.List;
import Containers.Panel;

public class Logger {
    private String input;
    private Scanner scanner;

    public Logger() {
        this.input = "";
        this.scanner = new Scanner(System.in);
    }

    private Boolean isValidNumber() {
        Pattern pattern = Pattern.compile("^[1-9]$");
        Matcher matcher = pattern.matcher(this.input);
        return matcher.find();
    }

    private Boolean isValidChoice() {
        Pattern pattern = Pattern.compile("^[YyNn]$");
        Matcher matcher = pattern.matcher(this.input);
        return matcher.find();
    }

    private Boolean transformChoice() {
        if (this.input.equals("Y") || this.input.equals("y")) {
            return true;
        }
        else {
            return false;
        }
    }

    public Integer askForNumber(Panel panel, List<Integer> emptyPanel) {
        Boolean valid = false;
        
        while (!valid) {
            System.out.print("Please enter your panel number to draw");
            panel.draw();
            System.out.print(": ");
            this.input = this.scanner.nextLine();
            
            if (this.isValidNumber()) {
                valid = true;
                if (!emptyPanel.contains(Integer.parseInt(input))) {
                    valid = false;
                    System.out.println("Sorry, cannot draw on that panel");
                }
            }
            else {
                System.out.println("Please enter number between 1 - 9");
            }
        }

        return Integer.parseInt(input);
    }

    public Boolean askForChoice(String prompt) {
        Boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            this.input = this.scanner.nextLine();
            
            if (this.isValidChoice()) {
                valid = true;
            }
            else {
                System.out.println("Please enter Yes (Y) or No (N)");
            }
        }

        return this.transformChoice();
    }

    public void announceRules() {
        System.out.println("|               GAME RULES                 |");
        System.out.println("--------------------------------------------");
        System.out.println("-The game consist of a 3 x 3 board.");
        System.out.println("-You can win by making 3 consecutive symbols");
        System.out.println(" horizontally, vertically, or diagonally.");
        System.out.println("-You can choose your symbol and if you want");
        System.out.println(" to go first or not before the game start.");
        System.out.println("-To draw the symbol on board, please input a");
        System.out.println(" number between 1-9, representing the panel");
        System.out.println(" number from upper left to bottom right.");
        System.out.println("                GOOD LUCK !                 ");
    }

    public void announceSection(String section) {
        System.out.println("--------------------------------------------");
        System.out.println(section);
        System.out.println("--------------------------------------------");
    }
    
    public void announceWinner(Boolean isHuman, Boolean thereIsWin) {
        if (!thereIsWin) {
            System.out.println("Woww, it is a draw :O");
        }
        else {
            if (isHuman) {
                System.out.println("Congratulations, you won the game!");
            }
            else {
                System.out.println("Sorry, the bot takes the W :(");
            }   
        }
    }
}
