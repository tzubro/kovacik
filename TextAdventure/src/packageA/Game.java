package packageA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    //instances of class
    private ChoiceHandler choiceHandler;
    private UI ui;
    private Story story;

    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        choiceHandler = new ChoiceHandler();
        ui = new UI();
        story = new Story(this, ui);
//        ui.createUI(choiceHandler);
        ui.createMainScreen(choiceHandler);
        ui.createGameScreen(choiceHandler);
        story.defaultSetting();
        ui.showMainScreen();
    }

    // vyuzitie ActionListenera a ActionEventu na vykonanie jednotlivych tahov
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            ActionCommand yourTurn = ActionCommand.valueOf(event.getActionCommand());

            switch (yourTurn) {
                case START:
                    ui.showGameScreen();
                    story.castleGate();
                    break;
                case TURN_1:
                    story.selectPosition1();
                    break;
                case TURN_2:
                    story.selectPosition2();
                    break;
                case TURN_3:
                    story.selectPosition3();
                    break;
                case TURN_4:
                    story.selectPosition4();
                    break;
            }
        }
    }
}