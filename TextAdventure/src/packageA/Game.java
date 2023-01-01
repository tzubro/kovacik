package packageA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    //instances of class
    private ChoiceHandler choiceHandler;
    private UI ui;
    private ScreenManager screenManager;
    private Story story;

    private String nextPosition1;
    private String nextPosition2;
    private String nextPosition3;
    private String nextPosition4;

    public void start(){
        choiceHandler = new ChoiceHandler();
        ui = new UI();
        screenManager = new ScreenManager(ui);
        story = new Story(this, ui, screenManager);
//        ui.createUI(choiceHandler);
        ui.createMainScreen(choiceHandler);
        ui.createGameScreen(choiceHandler);
        story.defaultSetting();
        ui.showMainScreen();
    }

    public static void main(String[] args) {
        new Game().start();
    }

    // vyuzitie ActionListenera a ActionEventu na vykonanie jednotlivych tahov
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourTurn = event.getActionCommand();

            switch (yourTurn) {
                case "Start":
                    ui.showGameScreen();
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
        nextPosition1 = position1;
        nextPosition2 = position2;
        nextPosition3 = position3;
        nextPosition4 = position4;
    }
}