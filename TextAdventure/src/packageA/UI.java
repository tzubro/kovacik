package packageA;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class UI {
    private JFrame window;
    private JPanel panelTitleName;
    private JPanel panelStartButton;
    private JPanel panelMainText;
    private JPanel panelChoiceButton;
    private JPanel panelPlayer;
    private JLabel labelTitleName;
    private JLabel labelHp;
    private JLabel labelHpCount;
    private JLabel labelWeapon;
    private JLabel labelWeaponName;
    private JButton startButton;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JTextArea mainTextArea;
    private Font fontTitle = new Font("Arial", Font.BOLD, 40);
    private Font fontNormal = new Font("Arial", Font.PLAIN, 24);

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public JPanel getPanelTitleName() {
        return panelTitleName;
    }

    public void setPanelTitleName(JPanel panelTitleName) {
        this.panelTitleName = panelTitleName;
    }

    public JPanel getPanelStartButton() {
        return panelStartButton;
    }

    public void setPanelStartButton(JPanel panelStartButton) {
        this.panelStartButton = panelStartButton;
    }

    public JPanel getPanelMainText() {
        return panelMainText;
    }

    public void setPanelMainText(JPanel panelMainText) {
        this.panelMainText = panelMainText;
    }

    public JPanel getPanelChoiceButton() {
        return panelChoiceButton;
    }

    public void setPanelChoiceButton(JPanel panelChoiceButton) {
        this.panelChoiceButton = panelChoiceButton;
    }

    public JPanel getPanelPlayer() {
        return panelPlayer;
    }

    public void setPanelPlayer(JPanel panelPlayer) {
        this.panelPlayer = panelPlayer;
    }

    public JLabel getLabelTitleName() {
        return labelTitleName;
    }

    public void setLabelTitleName(JLabel labelTitleName) {
        this.labelTitleName = labelTitleName;
    }

    public JLabel getLabelHp() {
        return labelHp;
    }

    public void setLabelHp(JLabel labelHp) {
        this.labelHp = labelHp;
    }

    public JLabel getLabelHpCount() {
        return labelHpCount;
    }

    public void setLabelHpCount(JLabel labelHpCount) {
        this.labelHpCount = labelHpCount;
    }

    public JLabel getLabelWeapon() {
        return labelWeapon;
    }

    public void setLabelWeapon(JLabel labelWeapon) {
        this.labelWeapon = labelWeapon;
    }

    public JLabel getLabelWeaponName() {
        return labelWeaponName;
    }

    public void setLabelWeaponName(JLabel labelWeaponName) {
        this.labelWeaponName = labelWeaponName;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getChoice1() {
        return choice1;
    }

    public void setChoice1(JButton choice1) {
        this.choice1 = choice1;
    }

    public JButton getChoice2() {
        return choice2;
    }

    public void setChoice2(JButton choice2) {
        this.choice2 = choice2;
    }

    public JButton getChoice3() {
        return choice3;
    }

    public void setChoice3(JButton choice3) {
        this.choice3 = choice3;
    }

    public JButton getChoice4() {
        return choice4;
    }

    public void setChoice4(JButton choice4) {
        this.choice4 = choice4;
    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public void setMainTextArea(JTextArea mainTextArea) {
        this.mainTextArea = mainTextArea;
    }

    public Font getFontTitle() {
        return fontTitle;
    }

    public void setFontTitle(Font fontTitle) {
        this.fontTitle = fontTitle;
    }

    public Font getFontNormal() {
        return fontNormal;
    }

    public void setFontNormal(Font fontNormal) {
        this.fontNormal = fontNormal;
    }

    public void createUI(Game.ChoiceHandler choiceHandler) {
        // okno
        window = new JFrame();
        window.setSize(1800, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);

        // titulna obrazovka
        panelTitleName = new JPanel();
        panelTitleName.setBounds(700, 400, 400, 250);
        panelTitleName.setBackground(Color.green);
        labelTitleName = new JLabel("TextAdventure");
        labelTitleName.setForeground(Color.white);
        labelTitleName.setFont(fontTitle);
        panelTitleName.add(labelTitleName);
        panelStartButton = new JPanel();
        panelStartButton.setBounds(200, 250, 500, 800);
        panelStartButton.setBackground(Color.orange);
        panelStartButton.setVisible(true);
        startButton = new JButton();
        startButton.setBounds(100, 100, 400, 500);
        startButton.setBackground(Color.gray);
        startButton.setForeground(Color.white);
        startButton.setFont(fontNormal);
        startButton.setFocusPainted(false);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("Start");
        startButton.setVisible(true);
        panelStartButton.add(startButton);
        window.add(panelTitleName);
        window.add(panelStartButton);
        window.setVisible(true);

        // herna obrazovka
        panelMainText = new JPanel();
        panelMainText.setBounds(100, 100, 500, 275);
        panelMainText.setBackground(Color.gray);
        window.add(panelMainText);

        mainTextArea = new JTextArea("Type here your commands");
        mainTextArea.setBounds(100, 100, 500, 275);
        mainTextArea.setBackground(Color.gray);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(fontNormal);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        panelMainText.add(mainTextArea);

        panelChoiceButton = new JPanel();
        panelChoiceButton.setBounds(250, 300, 250, 125);
        panelChoiceButton.setBackground(Color.orange);
        panelChoiceButton.setLayout(new GridLayout(4, 1));
        window.add(panelChoiceButton);
        choice1 = new JButton("1st choice");
        choice1.setBackground(Color.orange);
        choice1.setForeground(Color.white);
        choice1.setFont(fontNormal);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("turn1");
        choice1.setVisible(true);
        panelChoiceButton.add(choice1);
        choice2 = new JButton("2nd choice");
        choice2.setBackground(Color.gray);
        choice2.setForeground(Color.white);
        choice2.setFont(fontNormal);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("turn2");
        choice2.setVisible(true);
        panelChoiceButton.add(choice2);
        choice3 = new JButton("3rd choice");
        choice3.setBackground(Color.gray);
        choice3.setForeground(Color.white);
        choice3.setFont(fontNormal);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("turn3");
        choice3.setVisible(true);
        panelChoiceButton.add(choice3);
        choice4 = new JButton("4th choice");
        choice4.setBackground(Color.gray);
        choice4.setForeground(Color.white);
        choice4.setFont(fontNormal);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("turn4");
        choice4.setVisible(true);
        panelChoiceButton.add(choice4);
        panelPlayer = new JPanel();
        panelPlayer.setBounds(100, 25, 525, 60);
        panelPlayer.setBackground(Color.gray);
        panelPlayer.setLayout(new GridLayout(1, 4));
        window.add(panelPlayer);
        labelHp = new JLabel("HP:");
        labelHp.setFont(fontNormal);
        labelHp.setForeground(Color.white);
        panelPlayer.add(labelHp);
        labelHpCount = new JLabel();
        labelHpCount.setFont(fontNormal);
        labelHpCount.setForeground(Color.white);
        panelPlayer.add(labelHpCount);
        labelWeapon = new JLabel("Weapon:");
        labelWeapon.setFont(fontNormal);
        labelWeapon.setForeground(Color.white);
        labelWeapon.setBackground(Color.orange);
        panelPlayer.add(labelWeapon);
        labelWeaponName = new JLabel();
        labelWeaponName.setFont(fontNormal);
        labelWeaponName.setForeground(Color.white);
        panelPlayer.add(labelWeaponName);
    }

    public void setLabelDefaultText(String hpText, String weaponName) {
        getLabelHpCount().setText(hpText);
        getLabelWeaponName().setText(weaponName);
    }

    public void setTurnText(String mainTextArea, String choice1, String choice2, String choice3, String choice4) {
        getMainTextArea().setText(mainTextArea);
        getChoice1().setText(choice1);
        getChoice2().setText(choice2);
        getChoice3().setText(choice3);
        getChoice4().setText(choice4);
    }
}
