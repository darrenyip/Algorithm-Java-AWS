package csi403;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


/**
 * Created by zhangyu ye on 3/28/2018.
 */

public class Map< K , V >{

    ArrayList<HashNode<K, V>> bucket =new ArrayList<>();
    int numBuckets=10;
    int size = 0;
    public Map()
    {
        for(int i=0;i<numBuckets;i++)
        {
            bucket.add(null);
        }
    }
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }

    private int getHsIndex(K key){
        String keyString = key.toString();
        byte[] ascii = keyString.toLowerCase().getBytes(StandardCharsets.US_ASCII);
        int hashedNumber = 0;
        for(int i : ascii) {
            hashedNumber += i;
        }
        return hashedNumber % numBuckets;
    }



    public V get(K key)
    {
        int index=getHsIndex(key);
        HashNode<K, V> head=bucket.get(index);
        System.out.println("get index"+ index);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
    public V remove(K key)
    {
        int index=getHsIndex(key);
        HashNode<K, V> head = bucket.get(index);
        if(head==null)
        {
            return null;
        }
        if(head.key.equals(key))
        {
            V val=head.value;
            head=head.next;
            bucket.set(index, head);
            size--;
            return val;
        }
        else
        {
            HashNode<K, V>prev=null;
            while(head!=null)
            {

                if(head.key.equals(key))
                {
                    prev.next=head.next;
                    size--;
                    return head.value;
                }
                prev=head;
                head=head.next;
            }
            size--;
            return null;
        }
    }
    public void add(K key,V value)
    {

        int index=getHsIndex(key);
        System.out.println(index);
        HashNode<K, V>head=bucket.get(index);
        HashNode<K, V>toAdd=new HashNode<>();
        toAdd.key=key;
        toAdd.value=value;
        if(head==null)
        {
            bucket.set(index, toAdd);
            size++;

        }
        else
        {
            while(head!=null)
            {
                if(head.key.equals(key))
                {
                    head.value=value;
                    size++;
                    break;
                }
                head=head.next;
            }
            if(head==null)
            {
                head=bucket.get(index);
                toAdd.next=head;
                bucket.set(index, toAdd);
                size++;
            }
        }
        if((1.0*size)/numBuckets>0.7)
        {
            //do something
            ArrayList<HashNode<K, V>>tmp=bucket;
            bucket=new ArrayList<>();
            numBuckets = 2*numBuckets;
            for(int i=0;i < numBuckets;i++)
            {
                bucket.add(null);
            }
            for(HashNode<K, V> headNode:tmp)
            {
                while(headNode!=null)
                {
                    add(headNode.key, headNode.value);
                    headNode=headNode.next;
                }
            }


        }

    }



    public ArrayList<ArrayList<String>> collision(){
        ArrayList<ArrayList<String>> node= new ArrayList<ArrayList<String>>();
        int index = 0;
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
        while( index < bucket.size()){
            System.out.println("index = "+ bucket.size());
            if(bucket.get(index)!=null){
                HashNode<K,V> head = bucket.get(index);
                while(head != null){
                    if(head.value != null && index == 0){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner0.add(valueString);
                    }
                    if(head.value != null && index == 1){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner1.add(valueString);
                    }
                    if(head.value != null && index == 2){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner2.add(valueString);
                    }
                    if(head.value != null && index == 3){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner3.add(valueString);
                    }
                    if(head.value != null && index == 4){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner4.add(valueString);
                    }
                    if(head.value != null && index == 5){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner5.add(valueString);
                    }
                    if(head.value != null && index == 6){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner6.add(valueString);
                    }
                    if(head.value != null && index == 7){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner7.add(valueString);
                    }
                    if(head.value != null && index == 8){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner8.add(valueString);
                    }
                    if(head.value != null && index == 9){
                        String valueString = head.value.toString();
                        System.out.println(head.value);//test print
                        inner9.add(valueString);
                    }
                    head = head.next;
                }
            }
            index++;
            System.out.println("___________________________");
        }

        node.add(inner0);
        node.add(inner1);
        node.add(inner2);
        node.add(inner3);
        node.add(inner4);
        node.add(inner5);
        node.add(inner6);
        node.add(inner7);
        node.add(inner8);
        node.add(inner9);
        return node;
    }


    public void printNode(ArrayList<ArrayList<String>> node){
        for(int i = 0; i < node.size(); i++){
            System.out.println("---this is node =" + i +"-------");
            System.out.println(node.get(i));
            System.out.println("-----------------------------");
        }

    }

    public static void main(String[] args)
    {
        Map<String,Integer> map = new Map<>();
        System.out.println("Bob index = ");
        map.add("Bob",2);
        System.out.println("bob index = ");
        map.add("bob",3);
        System.out.println("bbo index = ");
        map.add("bbo",4);
        System.out.println("job index = ");
        map.add("job",5);
        System.out.println("print Bob and its value");
        System.out.println(map.get("Bob"));
        System.out.println("print bob and its value");
        System.out.println(map.get("bob"));
        System.out.println("print bbo and its value");
        System.out.println(map.get("bbo"));
//        System.out.println(map.remove("Bob"));
//        System.out.println(map.remove("bob"));
//        System.out.println(map.remove("bbo"));
        System.out.println("**********************");
        map.printNode(map.collision());


    }
}