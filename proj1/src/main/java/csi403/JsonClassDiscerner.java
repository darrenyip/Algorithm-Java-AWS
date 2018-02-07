package csi403; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String sort(String jsonStr){
        ObjectMapper mapper = new ObjectMapper();
        InList newlist = null;
        JsonSerializer serializer = new JsonSerializer();

        try {
            long lStartTime = System.nanoTime();
            newlist = mapper.readValue(jsonStr, InList.class);
            Arrays.sort(newlist.getInList());
            long lEndTime = System.nanoTime();
            long output = (lEndTime - lStartTime)/1000000;
            newlist.setTimeMS(output);
            newlist.setAlgorithm("QuickSort");
            return serializer.serialize(newlist);

        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }


    }


    // test app 
    public static void main(String[] args) {
        String case1 = "{ \"inList\" : [ 6, 4, 2, 1 ] }";
        String case2 = "{ }";
        String case3 = "{ \"inList\" : [ ] }";
        String case4 = "{ \"inList\" : }";
        String case5 = "{ \"inList\" : [ 2, 4, 6, 8, 10, 12 ] }";
        String case6 = "{ \"inList\" : [ 3, 3, 2, 2, 1, 1 ] }";

        System.out.println("1:  " + case1 + "  -->  " + new JsonClassDiscerner().sort(case1));
        System.out.println("2:  " + case2 + "  -->  " + new JsonClassDiscerner().sort(case2));
        System.out.println("3:  " + case3 + "  -->  " + new JsonClassDiscerner().sort(case3));
        System.out.println("4:  " + case4 + "  -->  " + new JsonClassDiscerner().sort(case4));
        System.out.println("5:  " + case5 + "  -->  " + new JsonClassDiscerner().sort(case5));
        System.out.println("6:  " + case6 + "  -->  " + new JsonClassDiscerner().sort(case6));

    }
}
