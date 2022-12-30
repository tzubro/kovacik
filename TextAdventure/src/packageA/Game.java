package packageA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    //instances of class
    ChoiceHandler choiceHandler = new ChoiceHandler();
    UI ui = new UI();
    ScreenManager screenManager = new ScreenManager(ui);
    Story story = new Story(this, ui, screenManager);

    private String nextPosition1;
    private String nextPosition2;
    private String nextPosition3;
    private String nextPosition4;

    public Game() {
        ui.createUI(choiceHandler);
        story.defaultSetting();
        screenManager.showTitleScreen();
    }

    public static void main(String[] args) {
        new Game();
    }

    public String getNextPosition1() {
        return nextPosition1;
    }

    public void setNextPosition1(String nextPosition1) {
        this.nextPosition1 = nextPosition1;
    }

    public String getNextPosition2() {
        return nextPosition2;
    }

    public void setNextPosition2(String nextPosition2) {
        this.nextPosition2 = nextPosition2;
    }

    public String getNextPosition3() {
        return nextPosition3;
    }

    public void setNextPosition3(String nextPosition3) {
        this.nextPosition3 = nextPosition3;
    }

    public String getNextPosition4() {
        return nextPosition4;
    }

    public void setNextPosition4(String nextPosition4) {
        this.nextPosition4 = nextPosition4;
    }

    // vyuzitie ActionListenera a ActionEventu na vykonanie jednotlivych tahov
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourTurn = event.getActionCommand();

            switch (yourTurn) {
                case "Start":
                    screenManager.showGameScreen();
                    story.castleGate();
                    break;
                case "turn1":
                    story.selectPosition(nextPosition1);
                    break;
                case "turn2":
                    story.selectPosition(nextPosition2);
                    break;
                case "turn3":
                    story.selectPosition(nextPosition3);
                    break;
                case "turn4":
                    story.selectPosition(nextPosition4);
                    break;
            }
        }
    }

    public void setNextPosition(String position1, String position2, String position3, String position4) {
        setNextPosition1(position1);
        setNextPosition2(position2);
        setNextPosition3(position3);
        setNextPosition4(position4);
    }
}