package csi403;

import java.util.Arrays;

/**
 * Created by Darren on 2/6/2018.
 */
public class InList {
    private int[] inList;
    private long timeMS;
    private String algorithm;

    public int[] getInList() {
        return inList;
    }

    public void setInList(int[] inList) {
        this.inList = inList;
    }

    public long getTimeMS() {
        return timeMS;
    }

    public void setTimeMS(long timeMS) {
        this.timeMS = timeMS;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        return "InList{" +
                "inList=" + Arrays.toString(inList) +
                '}';
    }
}
