package csi403;

/**
 * Created by Darren on 2/28/2018.
 */
public class Job extends InList implements Comparable<Job>{
    private String cmd;
    private String name;
    private int pri;

    public Job() {
    }


    public Job(String cmd, String name, int pri) {
        this.cmd = cmd;
        this.name = name;
        this.pri = pri;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }



    //----------------check the priority of the input String -------------------
    public boolean equals (Job other){
        return this.getPri() == other.getPri();
    }

    public int compareTo(Job other) {
        if (this.equals(other))
            return 0;
        else if(getPri() > other.getPri())
            return 1;
        else
            return -1;
    }


    //-----------toString method-------------------
    @Override
    public String toString() {
        return "Job{" +
                "cmd='" + cmd + '\'' +
                ", name='" + name + '\'' +
                ", pri=" + pri +
                '}';
    }
}
