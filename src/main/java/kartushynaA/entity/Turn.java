package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class Turn {
    private int id;
    private int numOfTurn;

    public Turn() {
    }

    public Turn(int id, int numOfTurn) {
        this.id = id;
        this.numOfTurn = numOfTurn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfTurn() {
        return numOfTurn;
    }

    public void setNumOfTurn(int numOfTurn) {
        this.numOfTurn = numOfTurn;
    }


}
