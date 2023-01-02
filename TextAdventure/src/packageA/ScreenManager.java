package packageA;

public class ScreenManager {

    private final Story story;


    public ScreenManager(UI uInterface, Story story) {
        this.story = story;
    }


    public void showGameScreen() {

//        //skryje titulnu obrazovku
//        ui.getPanelTitleName().setVisible(false); //skryje titulny nazov
//        ui.getLabelTitleName().setVisible(false);
//        ui.getPanelStartButton().setVisible(false); //a tlacidlo start
//
//        //ukaze hernu obrazovku
//        ui.getPanelMainText().setVisible(true); //ukaze panel s textom,
//        ui.getPanelChoiceButton().setVisible(true); //tlacidla vyberu
//        ui.getPanelPlayer().setVisible(true); //a panel hraca
//
//        ui.changeChoiceButtonVisibility(true);


    }

    public void showTitleScreen() {

//        ui.createMainScreen();
//
//        //skryje titulnu obrazovku
//        ui.getPanelTitleName().setVisible(true); //ukaze titulny nazov
//        ui.getPanelStartButton().setVisible(true); //a tlacidlo start
//
//        //ukaze hernu obrazovku
//        ui.getPanelMainText().setVisible(false); //skryje panel s textom,
//        ui.getPanelChoiceButton().setVisible(false); //tlacidla vyberu
//        ui.getPanelPlayer().setVisible(false); //a panel hraca
    }
}
