package packageA;

import packageB.Weapon_Knife;
import packageB.Weapon_LongSword;
import packageB.Monster;
import packageB.Monster_Sauron;
import packageB.Monster_Dragon;

import java.util.Random;

public class Story {

    private Game game;
    private UI ui;
    private ScreenManager screenManager;
    private Monster monster;
    private int goldenRing;
    private Player player;


    public Story(Game g, UI uInterface, ScreenManager sManager) {
        game = g;
        ui = uInterface;
        screenManager = sManager;
        player = new Player();
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
        game.setNextPosition("talkGuard", "attackGuard", "crossRoadOfPaths", "");
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
        player.setHp(player.getHp() - 3);
        ui.setLabelHpCountText("" + player.getHp());
        ui.setTurnText("Guard: See, what you've done?\\n\\nThe guard fought you back and hit you hard.\\n(You receive 3 damage points)",
                ">", "", "", "");
        game.setNextPosition("castleGate", "", "", "");
    }

    public void crossRoadOfPaths() {
        ui.setTurnText("You're at the crossing of 4 paths.\nIf you go south, you'll go back to the \ncastle",
                "Go east",
                "Go west",
                "Go south",
                "Go north");

        game.setNextPosition("east", "west", "castleGate", "north");
    }

    public void east() {
        player.setHp(player.getHp() + 2);
        ui.setLabelHpCountText("" + player.getHp());
        ui.setTurnText("There's a river. \nDrink the water and rest at the \nriverside. \n\n(Your HP are recovered by 2)",
                "Go west",
                "",
                "",
                "");

        game.setNextPosition("crossRoadOfPaths", "", "", "");
    }

    public void west() {
        player.setCurrentWeapon(new Weapon_LongSword());
        ui.setLabelWeaponName(player.getCurrentWeapon().getName());
        ui.setTurnText("You've walked into a forest and found a \nlong sword!\n\n(You've obtained a long sword)",
                "Go south",
                "",
                "",
                "");

        game.setNextPosition("crossRoadOfPaths", "", "", "");
    }


    public void north() {
        int i = new java.util.Random().nextInt(100) + 1; //vygeneruje nahodnu hodnotu pre vyber monstra, s ktorym bude hrac bojovat

        if (i < 90) {
            monster = new Monster_Sauron();
        } else {
            monster = new Monster_Dragon();
        }
        ui.setTurnText("You encountered a \" + monster.getName() + !",
                "Fight",
                "Run",
                "",
                "");

        game.setNextPosition("fight", "crossRoadOfPaths", "", "");

    }

    public void fight() {
        ui.setTurnText(monster.getName() + ": " + monster.getHp() + "\n\nWhat do you do?",
                "Attack",
                "Run",
                "",
                "");

        game.setNextPosition("attackOfPlayer", "crossRoadOfPaths", "", "");
    }

    public void attackOfPlayer() {

        int playerDamage = 0;

        playerDamage = new java.util.Random().nextInt(player.getCurrentWeapon().getDamage()); //generuje nahodne poskodenie sposobene hracom
        monster.setHp(monster.getHp() - playerDamage);
        ui.setTurnText("You've attacked the monster and \ngave " + playerDamage + " damage!",
                ">",
                "",
                "",
                "");

        if (monster.getHp() > 0) {
            game.setNextPosition("monsterAttack", "", "", "");
        } else if (monster.getHp() <= 0) {
            game.setNextPosition("win", "", "", "");
        }
    }

    public void attackOfMonster() {
        int monsterDamage = 0;

        monsterDamage = new Random().nextInt(monster.getAttack()); //generuje nahodne poskodenie sposobene monstrom

        player.setHp(player.getHp() - monsterDamage);
        ui.setLabelHpCountText("" + player.getHp());
        ui.setTurnText(monster.getAttackMessage() + "\nYou've received " + monsterDamage + " damage!",
                ">",
                "",
                "",
                "");

        if (player.getHp() > 0) {
            game.setNextPosition("fight", "", "", "");
        } else if (player.getHp() <= 0) {
            game.setNextPosition("lose", "", "", "");
        }
    }

    public void win() {
        goldenRing = 1;
        ui.setTurnText("You've defeated the monster!\nIt has dropped a ring!\n\n(You've obtained a Golden Ring)",
                "Go north",
                "",
                "",
                "");
        game.setNextPosition("backToTheTitleScreen", "", "", "");
    }

    public void ending() {
        ui.setTurnText("Guard: Oh, you've killed that Sauron!?\nI appreciate you! You're the chosen one!\nWelcome to our castle!\n\n<The end>",
                "",
                "",
                "",
                "");
        ui.changeChoiceButtonVisibility(false);
    }

    public void backToTitleScreen() {
        defaultSetting();
        screenManager.showTitleScreen();
    }
}
