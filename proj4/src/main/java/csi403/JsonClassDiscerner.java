package csi403; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Point;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.List; 

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
    	 ObjectMapper mapper = new ObjectMapper();
         JsonSerializer serializer = new JsonSerializer();
         Contain input = new Contain();

         // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
         /**
          * Initial the hit class for incoming JSON data
          */
         InList inList = null;
         final int MAXPOSITION = 18;
         try {
             inList = mapper.readValue(jsonStr, InList.class);

             int count = 0;
             Point[] polygon = new Point[inList.getInList().size()];

             /**
              * Collect points and save into points array
              */
             for (int i  = 0; i < inList.getInList().size(); i++) {
                 Point temp = new Point(inList.getInList().get(i).getX(),inList.getInList().get(i).getY());
                 polygon[count++] = temp;
             }


             Polygon py = new Polygon();
             for(int i =0; i < polygon.length;i++){
                 int x  = (int)polygon[i].getX();
                 int y  = (int)polygon[i].getY();
                 py.addPoint(x,y);
             }



             count = 0;
             for (int i = 0; i <= MAXPOSITION; i++) {
                 for (int j = 0; j <= MAXPOSITION; j++) {
                     Point point = new Point(i, j);
                     if(input.isPointOnLine(point,input.convexHull(polygon,polygon.length)) == false){
                         if(py.contains(point) == true){
                             count++;
                         }
                     }
                 }
             }


             /**
              * Format the result for output JASON
              */
             OutList outList = new OutList();
             outList.setCount(count);
             return serializer.serialize(outList);
         }
         catch (Exception e) {
             return "{ \"message\" : \"Error - Malformed JSON\" } ";
         }
    }


    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();

        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 2,\"y\": 1}, {\"x\": 2,\"y\": 4}, {\"x\": 8,\"y\": 4}, {\"x\": 11,\"y\": 1}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 0,\"y\": 0}, {\"x\": 0,\"y\": 2}, {\"x\": 2,\"y\": 2}, {\"x\": 3,\"y\": 0}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 1,\"y\": 1}, {\"x\": 1,\"y\": 3}, {\"x\": 4,\"y\": 3}, {\"x\": 4,\"y\": 1}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 1,\"y\": 5}, {\"x\": 3,\"y\": 10}, {\"x\": 7,\"y\": 10}, {\"x\": 7,\"y\": 5}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 11,\"y\": 7}, {\"x\": 11,\"y\": 10}, {\"x\": 14,\"y\": 7}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 1,\"y\": 1}, {\"x\": 1,\"y\": 3}, {\"x\": 6,\"y\": 3}, {\"x\": 5,\"y\": 1}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 0,\"y\": 0}, {\"x\": 1,\"y\": 4}}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 2,\"y\": 1}, {\"x\": 2,\"y\": 4}, {\"x\": 8,\"y\": 4}, {\"x\": 11,\"y\": 1}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}
