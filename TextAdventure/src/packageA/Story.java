package packageA;

import packageB.Weapon_Knife;
import packageB.Weapon_LongSword;
import packageB.Monster;
import packageB.Monster_Sauron;
import packageB.Monster_Dragon;
public class Story {

    private Game game;
    private UI ui;
    private ScreenManager screenManager;
    private Monster monster;
    int goldenRing = 0;

    private Player player = new Player();


    public Story(Game g, UI uInterface, ScreenManager sManager) {

        game = g;
        ui = uInterface;
        screenManager = sManager;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }


    //nastavi hracovi zivoty a zbran
    public void defaultSetting() {
        player.setHp(10);
        player.setCurrentWeapon(new Weapon_Knife());
        ui.setLabelDefaultText("" + player.getHp(),player.getCurrentWeapon().getName());

        goldenRing = 0;
    }

    //sluzi na vyber tahu
    public void selectPosition(String nextPosition) {

        switch (nextPosition) {
            case "castleGate": castleGate(); break;
            case "talkGuard": talkGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoadOfPaths": crossRoadOfPaths(); break;
            case "north": north(); break;
            case "west": west(); break;
            case "east": east(); break;
            case "fight": fight(); break;
            case "attackOfPlayer": attackOfPlayer(); break;
            case "attackOfMonster": attackOfMonster(); break;
            case "win": win(); break;
            case "ending": ending(); break;
            case "backToTitleScreen": backToTitleScreen(); break;
        }
    }

    public void castleGate() {
        ui.setTurnText("You've reached the gate of the town. \nGuard is standing in front of you. \n\nWhat do you do?",
                "Talk to the guard",
                "Attack the guard",
                "Escape guard",
                "");
        game.setNextPosition1("talkGuard");
        game.setNextPosition2("attackGuard");
        game.setNextPosition3("crossRoadOfPaths");
        game.setNextPosition4("");
    }


    public void talkGuard() {
        if (goldenRing == 0) {
            ui.setTurnText("Guard: Hello, stranger. I've never seen you before. \nI'm sorry but that means I can't let you enter our castle.",
                    ">",
                    "", "", "");

            game.setNextPosition("castleGate", "", "", "");
        } else if (goldenRing == 1) { //ak hrac ziskal zlaty prsten, hra konci
            ending();
        }
    }



    public void attackGuard() {
        ui.getMainTextArea().setText("Guard: See, what you've done?\n\nThe guard fought you back and hit you hard.\n(You receive 3 damage points)");
        player.setHp(player.getHp() - 3);
        ui.getLabelHpCount().setText("" + player.getHp());
        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("castleGate");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void crossRoadOfPaths() {
        ui.getMainTextArea().setText("You're at the crossing of 4 paths.\nIf you go south, you'll go back to the \ncastle");
        ui.getChoice1().setText("Go east");
        ui.getChoice2().setText("Go west");
        ui.getChoice3().setText("Go south");
        ui.getChoice4().setText("Go north");

        game.setNextPosition1("east");
        game.setNextPosition2("west");
        game.setNextPosition3("castleGate");
        game.setNextPosition4("north");
    }

    public void east() {
        ui.getMainTextArea().setText("There's a river. \nDrink the water and rest at the \nriverside. \n\n(Your HP are recovered by 2)");

        player.setHp(player.getHp() + 2);
        ui.getLabelHpCount().setText("" + player.getHp());

        ui.getChoice1().setText("Go west");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoadOfPaths");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void west() {
        ui.getMainTextArea().setText("You've walked into a forest and found a \nlong sword!\n\n(You've obtained a long sword)");

        player.setCurrentWeapon(new Weapon_LongSword());
        ui.getLabelWeaponName().setText(player.getCurrentWeapon().getName());

        ui.getChoice1().setText("Go south");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoadOfPaths");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }


    public void north() {
        int i = new java.util.Random().nextInt(100) + 1; //vygeneruje nahodnu hodnotu pre vyber monstra, s ktorym bude hrac bojovat

        if (i < 90) {
            monster = new Monster_Sauron();
        } else {
            monster = new Monster_Dragon();
        }

        ui.getMainTextArea().setText("You encountered a " + monster.getName() + "!");
        ui.getChoice1().setText("Fight");
        ui.getChoice2().setText("Run");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("fight");
        game.setNextPosition2("crossRoadOfPaths");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void fight() {
        ui.getMainTextArea().setText(monster.getName() + ": " + monster.getHp() + "\n\nWhat do you do?");
        ui.getChoice1().setText("Attack");
        ui.getChoice2().setText("Run");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("attackOfPlayer");
        game.setNextPosition2("crossRoadOfPaths");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void attackOfPlayer() {

        int playerDamage = 0;

        playerDamage = new java.util.Random().nextInt(player.getCurrentWeapon().getDamage()); //generuje nahodne poskodenie sposobene hracom

        ui.getMainTextArea().setText("You've attacked the monster and \ngave " + playerDamage + " damage!");

        monster.setHp(monster.getHp() - playerDamage);

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        if (monster.getHp() > 0) {
            game.setNextPosition1("monsterAttack");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        } else if (monster.getHp() <= 0) {
            game.setNextPosition1("win");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        }
    }

    public void attackOfMonster() {
        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(monster.getAttack()); //generuje nahodne poskodenie sposobene monstrom

        ui.getMainTextArea().setText(monster.getAttackMessage() + "\nYou've received " + monsterDamage + " damage!");

        player.setHp(player.getHp() - monsterDamage);
        ui.getLabelHpCount().setText("" + player.getHp());

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        if (player.getHp() > 0) {
            game.setNextPosition1("fight");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        } else if (player.getHp() <= 0) {
            game.setNextPosition1("lose");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        }
    }

    public void win() {
        ui.getMainTextArea().setText("You've defeated the monster!\nIt has dropped a ring!\n\n(You've obtained a Golden Ring)");

        goldenRing = 1;

        ui.getChoice1().setText("Go north");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("backToTheTitleScreen");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void ending() {
        ui.getMainTextArea().setText("Guard: Oh, you've killed that Sauron!?\nI appreciate you! You're the chosen one!\nWelcome to our castle!\n\n<The end>");

        ui.getChoice1().setText("");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");
        ui.getChoice1().setVisible(false);
        ui.getChoice2().setVisible(false);
        ui.getChoice3().setVisible(false);
        ui.getChoice4().setVisible(false);
    }

    public void backToTitleScreen() {
        defaultSetting();
        screenManager.showTitleScreen();
    }
}
