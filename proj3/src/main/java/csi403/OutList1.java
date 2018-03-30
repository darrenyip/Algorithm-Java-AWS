package csi403;

import java.io.Serializable;
import java.util.ArrayList;

public class OutList1 implements Serializable {
    private ArrayList<String> outList = new ArrayList<>();

    public OutList1() {

    }

    public ArrayList<String> getOutList() {
        return outList;
    }

    public void setOutList(ArrayList<ArrayList<String>> node) {

        System.out.println(node.size());
        for(int i = 0 ; i < node.size(); i++){
            System.out.println(i);
//            System.out.println(node.get(i));
            String temp;
            if(node.get(i).size()>1){
                temp  =  node.get(i).toString();
                addIntoList(temp);
            }
//            System.out.println("aslkdjfhklasdjfhlkasjfhjksadhflkajshflkjashdfkl");


        }
    }

    private void addIntoList(String temp){
        outList.add(temp);
        System.out.println(temp);
    }


    public void print(){
        for(int i = 0; i < outList.size(); i++){
            System.out.println(outList.get(i));
        }
    }

}