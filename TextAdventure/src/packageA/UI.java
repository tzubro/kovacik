package packageA;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class UI {
    private JFrame startWindow;

    private JFrame gameWindow;
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

    public void createMainScreen(Game.ChoiceHandler choiceHandler){
        startWindow = new JFrame();
        startWindow.setSize(1800, 1000);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startWindow.getContentPane().setBackground(Color.black);

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
        startButton = createButton("Start", Color.orange, choiceHandler, "Start");
        panelStartButton.add(startButton);
        startWindow.getContentPane().add(BorderLayout.NORTH, panelTitleName);
        startWindow.getContentPane().add(BorderLayout.CENTER, panelStartButton);
        startWindow.setVisible(true);
    }

    public void createGameScreen(Game.ChoiceHandler choiceHandler) {
        // okno
        gameWindow = new JFrame();
        gameWindow.setSize(1800, 1000);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.black);
        gameWindow.setLayout(new GridBagLayout());

        // herna obrazovka
        panelMainText = new JPanel();
        panelMainText.setBounds(100, 100, 500, 275);
        panelMainText.setBackground(Color.gray);

        gameWindow.getContentPane().add(panelMainText, createGridBagConstraints(0, 0, 2));

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
        panelChoiceButton.setToolTipText("panel choice button");
        panelChoiceButton.setLayout(new GridLayout(4, 1));
        panelChoiceButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelChoiceButton.setPreferredSize(new Dimension(385, 450));

        gameWindow.getContentPane().add(panelChoiceButton, createGridBagConstraints(0,1, 1));
        choice1 = createButton("1st choice", Color.orange, choiceHandler, "turn1");
        panelChoiceButton.add(choice1);
        choice2 = createButton("2nd choice", Color.gray, choiceHandler, "turn2");
        panelChoiceButton.add(choice2);
        choice3 = createButton("3rd choice", Color.gray, choiceHandler, "turn3");
        panelChoiceButton.add(choice3);
        choice4 = createButton("4th choice", Color.gray, choiceHandler, "turn4");
        panelChoiceButton.add(choice4);
        panelPlayer = new JPanel();
        panelPlayer.setBounds(100, 25, 525, 60);
        panelPlayer.setBackground(Color.gray);
        panelPlayer.setLayout(new GridLayout(1, 4));

        gameWindow.getContentPane().add(panelPlayer, createGridBagConstraints(1, 1, 1));
        labelHp = createLabel("HP:", Color.white, null);
        panelPlayer.add(labelHp);
        labelHpCount = createLabel("HP:", Color.white, null);
        panelPlayer.add(labelHpCount);
        labelWeapon = createLabel("HP:", Color.white, null);
        panelPlayer.add(labelWeapon);
        labelWeaponName = createLabel("HP:", Color.white, null);
        panelPlayer.add(labelWeaponName);
    }

    private JLabel createLabel(String name, Color foregroundColor, Color backgroundColor) {
        JLabel label = new JLabel();
        if (nonNull(name)){
            label = new JLabel("HP: ");
        }
        label.setFont(fontNormal);
        label.setForeground(Color.white);
        if (nonNull(backgroundColor)){
            label.setBackground(backgroundColor);
        }
        return label;
    }

    private static GridBagConstraints createGridBagConstraints(int x, int y, int width) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        return gbc;
    }

    private JButton createButton(String text, Color gray, Game.ChoiceHandler choiceHandler, String command) {
        JButton button = new JButton(text);
        button.setBackground(gray);
        button.setForeground(Color.white);
        button.setFont(fontNormal);
        button.setFocusPainted(false);
        button.addActionListener(choiceHandler);
        button.setActionCommand(command);
        button.setVisible(true);
        return button;
    }

    public void setLabelDefaultText(String hpText, String weaponName) {
        setLabelHpCountText(hpText);
        setLabelWeaponName(weaponName);
    }

    public void setLabelWeaponName(String weaponName){
        labelWeaponName.setText(weaponName);
    }

    public void setLabelHpCountText(String hpText){
        labelHpCount.setText(hpText);
    }

    public void setTurnText(String mainTextAreaText, String choice1Text, String choice2Text, String choice3Text, String choice4Text) {
        mainTextArea.setText(mainTextAreaText);
        choice1.setText(choice1Text);
        choice2.setText(choice2Text);
        choice3.setText(choice3Text);
        choice4.setText(choice4Text);
    }

    public void changeChoiceButtonVisibility(boolean visibility){
        choice1.setVisible(visibility);
        choice2.setVisible(visibility);
        choice3.setVisible(visibility);
        choice4.setVisible(visibility);
    }

    public void showGameScreen(){
        startWindow.setVisible(false);
        gameWindow.setVisible(true);
    }

    public void showMainScreen(){
        gameWindow.setVisible(false);
        startWindow.setVisible(true);
    }
}
