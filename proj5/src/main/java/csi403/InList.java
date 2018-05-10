package csi403;
import java.io.Serializable;
import java.util.ArrayList;


public class InList implements Serializable {

    private ArrayList<Friends> inList;

    public InList() {
    }

    public ArrayList<Friends> getInList() {
        return inList;
    }

    public void setInList(ArrayList<Friends> inList) {
        this.inList = inList;
    }
}
