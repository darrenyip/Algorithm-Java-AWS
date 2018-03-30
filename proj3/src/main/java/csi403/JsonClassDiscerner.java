package csi403;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.*;


import java.util.PriorityQueue;
/**
 * Created by zhangyu ye on 3/28/2018.
 */

public class JsonClassDiscerner {


    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonSerializer serializer = new JsonSerializer();
        InList inList = null;
        ArrayList<String> keyList = new ArrayList<String>();
        Map<String,String>map=new Map<>();

        try{
            inList = mapper.readValue(jsonStr, InList.class);
            for(int i = 0; i < inList.getInList().size();i++){
                String temp = inList.getInList().get(i).toString();  //convert all letters to lowercase
                keyList.add(temp);
//                System.out.println(inList.getInList().get(i).toString());
//                System.out.println("-----------------------");
            }



            Iterator<String> itr = keyList.iterator();
            while (itr.hasNext()) {
                String element = itr.next();
                map.add(element,element);
                System.out.println(map.get(element));
                System.out.println("***************");
            }
            System.out.println("---------------------");


            OutList1 outList = new OutList1();
            outList.setOutList(map.collision());
            outList.print();
            return serializer.serialize(outList);


        }catch (Exception e) {
            System.out.println(e);
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
    }
//    public static void print(ArrayList<ArrayList<V>> hey){
//
//    }




    // test app
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        System.out.println("************************************");
        msg = "{\"inList\":[\"jksdfjlaskdjflksdjflskdjflkasjdflk\",\"ha\", \"obb\", \"er\", \"as\", \"d\", \"ff\"]}";
        System.out.println(msg);
        System.out.println("************************************");
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }


}
