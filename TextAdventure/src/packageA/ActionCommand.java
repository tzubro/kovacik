package packageA;

public enum ActionCommand {

    START("Start"),
    TURN_1("1st choice"),
    TURN_2("2nd choice"),
    TURN_3("3th choice"),
    TURN_4("4th choice");

    private String title;
    ActionCommand(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
