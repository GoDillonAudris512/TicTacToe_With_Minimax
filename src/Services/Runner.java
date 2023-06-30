package Services;

import Containers.Board;
import Containers.OPanel;
import Containers.XPanel;

public class Runner {
    private final Checker checker = new Checker();
    private final Logger logger = new Logger();

    private Board board;
    private Boolean thereIsWin;
    private Boolean isHumanTurn;

    private final Human human = new Human();
    private final Bot bot = new Bot();

    public Runner() {
        this.board = new Board();
        this.thereIsWin = false;
        this.isHumanTurn = true;
    }

    private void start() {
        this.logger.announceRules();
        this.setControl();
        this.logger.announceSection("|               GAME START!                |");

        do {
            this.board.draw();
            this.fillBoard();
            this.thereIsWin = this.checker.checkWinStatus(board, isHumanTurn ? this.human.tellPanel() : this.bot.tellPanel());
            if (!this.thereIsWin && !this.board.getEmptyPanel().isEmpty()) {
                System.out.println("--------------------------------------------");
                this.changePlayer();
            }
        } while (!this.thereIsWin && !this.board.getEmptyPanel().isEmpty());

        this.finish();
    }

    private void setControl() {
        this.logger.announceSection("|            SETTINGS CONTROL              |");
        this.isHumanTurn = this.logger.askForChoice("Do you want to start first (Y/n) ? ");
        System.out.println("--------------------------------------------");

        if (this.logger.askForChoice("Do you want to use X symbol (Y/n) ? ")) {
            this.human.assignPanel(new XPanel());
            this.bot.assignPanel(new OPanel());
        }
        else {
            this.human.assignPanel(new OPanel());
            this.bot.assignPanel(new XPanel());
        }
    }

    private void fillBoard() {
        if (this.isHumanTurn) {
            System.out.print("This is your turn (");
            this.human.tellPanel().draw();
            System.out.println(")");
            this.board.setPanel(this.logger.askForNumber(this.human.tellPanel(), this.board.getEmptyPanel()), this.human.tellPanel());
        }
        else {
            System.out.print("This is the bot turn (");
            this.bot.tellPanel().draw();
            System.out.println(")");
            Integer chosenPanel = this.bot.chooseAction(this.board);
            this.board.setPanel(chosenPanel, this.bot.tellPanel());
            System.out.print("The bot choose to draw");
            this.bot.tellPanel().draw();
            System.out.println("in panel " + chosenPanel);
        }
    }

    private void changePlayer() {
        this.isHumanTurn = !this.isHumanTurn;
    }

    private void finish() {
        this.logger.announceSection("|               GAME END!                 |");
        this.board.draw();
        this.logger.announceWinner(this.isHumanTurn, this.thereIsWin);
        System.out.println("--------------------------------------------");
    }

    private void reset() {
        this.board = new Board();
        this.thereIsWin = false;
        this.isHumanTurn = true;
    }

    public void run() {
        Boolean running = true;
        
        this.logger.announceSection("|               TIC-TAC-TOE                |");
        while (running) {
            this.reset();
            this.start();
            this.logger.announceSection("|                INTERLUDE                 |");
            running = this.logger.askForChoice("Do you want to play again (Y/n) ? ");
            if (!running) {
                System.out.println("--------------------------------------------");
            }
        }
    }
}