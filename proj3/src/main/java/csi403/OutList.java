package csi403;

import java.util.ArrayList;
/**
 * Created by zhangyu ye on 3/28/2018.
 */
public class OutList<V> {
    private ArrayList<ArrayList<V>> node;

    public OutList(ArrayList<ArrayList<String>> newNode) {
        ArrayList<ArrayList<String>> node= new ArrayList<ArrayList<String>>();
        ArrayList<String> inner0 = new ArrayList<>();
        ArrayList<String> inner1 = new ArrayList<>();
        ArrayList<String> inner2 = new ArrayList<>();
        ArrayList<String> inner3 = new ArrayList<>();
        ArrayList<String> inner4 = new ArrayList<>();
        ArrayList<String> inner5 = new ArrayList<>();
        ArrayList<String> inner6 = new ArrayList<>();
        ArrayList<String> inner7 = new ArrayList<>();
        ArrayList<String> inner8 = new ArrayList<>();
        ArrayList<String> inner9 = new ArrayList<>();
        for(int i = 0; i < newNode.size();i++){
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 0 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner0.add(newNode.get(i).get(j));
                }
                node.add(inner0);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 1 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner1.add(newNode.get(i).get(j));
                }
                node.add(inner1);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 2 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner2.add(newNode.get(i).get(j));
                }
                node.add(inner2);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 3 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner3.add(newNode.get(i).get(j));
                }
                node.add(inner3);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 4 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner4.add(newNode.get(i).get(j));
                }
                node.add(inner4);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 5 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner5.add(newNode.get(i).get(j));
                }
                node.add(inner5);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 6 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner6.add(newNode.get(i).get(j));
                }
                node.add(inner6);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 7 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner7.add(newNode.get(i).get(j));
                }
                node.add(inner7);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 8 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner8.add(newNode.get(i).get(j));
                }
                node.add(inner8);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 9 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner9.add(newNode.get(i).get(j));
                }
                node.add(inner9);
            }
        }


    }

    public void setNode(ArrayList<ArrayList<String>> newNode) {
        ArrayList<ArrayList<String>> node= new ArrayList<ArrayList<String>>();
        ArrayList<String> inner0 = new ArrayList<>();
        ArrayList<String> inner1 = new ArrayList<>();
        ArrayList<String> inner2 = new ArrayList<>();
        ArrayList<String> inner3 = new ArrayList<>();
        ArrayList<String> inner4 = new ArrayList<>();
        ArrayList<String> inner5 = new ArrayList<>();
        ArrayList<String> inner6 = new ArrayList<>();
        ArrayList<String> inner7 = new ArrayList<>();
        ArrayList<String> inner8 = new ArrayList<>();
        ArrayList<String> inner9 = new ArrayList<>();
        for(int i = 0; i < newNode.size();i++){
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 0 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner0.add(newNode.get(i).get(j));
                }
                node.add(inner0);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 1 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner1.add(newNode.get(i).get(j));
                }
                node.add(inner1);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 2 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner2.add(newNode.get(i).get(j));
                }
                node.add(inner2);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 3 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner3.add(newNode.get(i).get(j));
                }
                node.add(inner3);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 4 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner4.add(newNode.get(i).get(j));
                }
                node.add(inner4);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 5 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner5.add(newNode.get(i).get(j));
                }
                node.add(inner5);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 6 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner6.add(newNode.get(i).get(j));
                }
                node.add(inner6);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 7 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner7.add(newNode.get(i).get(j));
                }
                node.add(inner7);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 8 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner8.add(newNode.get(i).get(j));
                }
                node.add(inner8);
            }
            if(newNode.get(i) != null && newNode.get(i).size() > 1 && i == 9 ){
                for(int j = 0; j < newNode.get(i).size(); j++){
                    inner9.add(newNode.get(i).get(j));
                }
                node.add(inner9);
            }
        }

    }

    public ArrayList<ArrayList<V>> getNode() {
        return node;
    }



    public void printNode(){
        for(int i = 0; i < node.size(); i++){
            System.out.println("---this is node =" + i +"-------");
            System.out.println(node.get(i));
            System.out.println("-----------------------------");
        }

    }

}
