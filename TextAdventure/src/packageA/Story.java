package packageA;

import packageB.*;

import java.util.Random;

public class Story {

    private final Game game;
    private final UI ui;
    private final Player player;
    private Monster monster;
    private int goldenRing;

    private String nextPosition1;
    private String nextPosition2;
    private String nextPosition3;
    private String nextPosition4;

    public Story(Game g, UI uInterface) {
        game = g;
        ui = uInterface;
        player = new Player();
    }

    public void setNextPosition(String position1, String position2, String position3, String position4) {
        nextPosition1 = position1;
        nextPosition2 = position2;
        nextPosition3 = position3;
        nextPosition4 = position4;
    }

    public void selectPosition1() {
        selectPosition(nextPosition1);
    }

    public void selectPosition2() {
        selectPosition(nextPosition2);
    }

    public void selectPosition3() {
        selectPosition(nextPosition3);
    }

    public void selectPosition4() {
        selectPosition(nextPosition4);
    }

    //sluzi na vyber tahu
    public void selectPosition(String nextPosition) {

        switch (nextPosition) {
            case "castleGate":
                castleGate();
                break;
            case "talkGuard":
                talkGuard();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossRoadOfPaths":
                crossRoadOfPaths();
                break;
            case "north":
                north();
                break;
            case "west":
                west();
                break;
            case "east":
                east();
                break;
            case "fight":
                fight();
                break;
            case "attackOfPlayer":
                attackOfPlayer();
                break;
            case "attackOfMonster":
                attackOfMonster();
                break;
            case "win":
                win();
                break;
            case "ending":
                ending();
                break;
            case "backToTitleScreen":
                backToTitleScreen();
                break;
        }
    }

    //nastavi hracovi zivoty a zbran
    public void defaultSetting() {
        player.setHp(10);
        player.setCurrentWeapon(new Weapon_Knife());
        ui.setLabelDefaultText("" + player.getHp(), player.getCurrentWeapon().getName());

        goldenRing = 0;
    }

    public void castleGate() {
        ui.setTurnText("You've reached the gate of the town. \nGuard is standing in front of you. \n\nWhat do you do?",
                "Talk to the guard",
                "Attack the guard",
                "Escape guard",
                "");
        setNextPosition("talkGuard", "attackGuard", "crossRoadOfPaths", "");
    }


    public void talkGuard() {
        if (goldenRing == 0) {
            ui.setTurnText("Guard: Hello, stranger. I've never seen you before. \nI'm sorry but that means I can't let you enter our castle.",
                    ">",
                    "", "", "");

            setNextPosition("castleGate", "", "", "");
        } else if (goldenRing == 1) { //ak hrac ziskal zlaty prsten, hra konci
            ending();
        }
    }


    public void attackGuard() {
        player.setHp(player.getHp() - 3);
        ui.setLabelHpCountText("" + player.getHp());
        ui.setTurnText("Guard: See, what you've done?\\n\\nThe guard fought you back and hit you hard.\\n(You receive 3 damage points)",
                ">", "", "", "");
        setNextPosition("castleGate", "", "", "");
    }

    public void crossRoadOfPaths() {
        ui.setTurnText("You're at the crossing of 4 paths.\nIf you go south, you'll go back to the \ncastle",
                "Go east",
                "Go west",
                "Go south",
                "Go north");

        setNextPosition("east", "west", "castleGate", "north");
    }

    public void east() {
        player.setHp(player.getHp() + 2);
        ui.setLabelHpCountText("" + player.getHp());
        ui.setTurnText("There's a river. \nDrink the water and rest at the \nriverside. \n\n(Your HP are recovered by 2)",
                "Go west",
                "",
                "",
                "");

        setNextPosition("crossRoadOfPaths", "", "", "");
    }

    public void west() {
        player.setCurrentWeapon(new Weapon_LongSword());
        ui.setLabelWeaponName(player.getCurrentWeapon().getName());
        ui.setTurnText("You've walked into a forest and found a \nlong sword!\n\n(You've obtained a long sword)",
                "Go south",
                "",
                "",
                "");

        setNextPosition("crossRoadOfPaths", "", "", "");
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

        setNextPosition("fight", "crossRoadOfPaths", "", "");

    }

    public void fight() {
        ui.setTurnText(monster.getName() + ": " + monster.getHp() + "\n\nWhat do you do?",
                "Attack",
                "Run",
                "",
                "");

        setNextPosition("attackOfPlayer", "crossRoadOfPaths", "", "");
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
            setNextPosition("monsterAttack", "", "", "");
        } else if (monster.getHp() <= 0) {
            setNextPosition("win", "", "", "");
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
            setNextPosition("fight", "", "", "");
        } else if (player.getHp() <= 0) {
            setNextPosition("lose", "", "", "");
        }
    }

    public void win() {
        goldenRing = 1;
        ui.setTurnText("You've defeated the monster!\nIt has dropped a ring!\n\n(You've obtained a Golden Ring)",
                "Go north",
                "",
                "",
                "");
        setNextPosition("backToTheTitleScreen", "", "", "");
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
        ui.showMainScreen();
    }
}
