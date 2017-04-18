package kartushynaA.entity;

/**
 * Created by Анна on 18.04.2017.
 */
public class NumOfOrder {
    private int id;
    private int num;

    public NumOfOrder() {
    }

    public NumOfOrder(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
