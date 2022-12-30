package packageA;

import packageB.MainWeapon;

public class Player {

    private int hp;
    private MainWeapon currentWeapon;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public MainWeapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(MainWeapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }
}
