package packageA;

public class ScreenManager {

    private UI ui;

    public ScreenManager(UI uInterface) {
        ui = uInterface;
    }

    public void showGameScreen() {

        //skryje titulnu obrazovku
        ui.getPanelTitleName().setVisible(false); //skryje titulny nazov
        ui.getPanelStartButton().setVisible(false); //a tlacidlo start

        //ukaze hernu obrazovku
        ui.getPanelMainText().setVisible(true); //ukaze panel s textom,
        ui.getPanelChoiceButton().setVisible(true); //tlacidla vyberu
        ui.getPanelPlayer().setVisible(true); //a panel hraca
    }

    public void showTitleScreen() {

        //skryje titulnu obrazovku
        ui.getPanelTitleName().setVisible(true); //ukaze titulny nazov
        ui.getPanelStartButton().setVisible(true); //a tlacidlo start

        //ukaze hernu obrazovku
        ui.getPanelMainText().setVisible(false); //skryje panel s textom,
        ui.getPanelChoiceButton().setVisible(false); //tlacidla vyberu
        ui.getPanelPlayer().setVisible(false); //a panel hraca
    }
}
