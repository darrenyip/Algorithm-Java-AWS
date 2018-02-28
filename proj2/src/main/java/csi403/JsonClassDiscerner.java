package csi403;
/**
 * Created by zhangyu ye on 2/28/2018.
 */

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;


import java.util.PriorityQueue;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        PriorityQueue<Job> pQueue = new PriorityQueue<Job>();
        JsonSerializer serializer = new JsonSerializer();
        ArrayList<String> outlist = new ArrayList<String>();

        try{
            Job jobList = mapper.readValue(jsonStr, Job.class);
            System.out.println("see if the input is correct: ");
            for(int i = 0; i < jobList.getInList().size(); i++) {
                System.out.println(jobList.getInList().get(i).toString());
                System.out.println("---------------------------------------------");
            }

            for(int i = 0; i < jobList.getInList().size(); i++) {
                if(jobList.getInList().get(i).getCmd().equals("enqueue")) {
                    pQueue.add(jobList.getInList().get(i));
                } else if (jobList.getInList().get(i).getCmd().equals("dequeue")) {
                    pQueue.remove();
                } else {
                    return "cmd error";
                }
            }
            while(!pQueue.isEmpty()){
                outlist.add(pQueue.peek().getName());
                pQueue.remove();
            }
            OutList outList = new OutList();
            outList.setOutList(outlist);
            return serializer.serialize(outList);

        }catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
    }


    // test app 
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        System.out.println("************************************");
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}]}";
        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4},{\"cmd\":\"enqueue\", \"name\":\"job2\", \"pri\":3},{\"cmd\":\"dequeue\"},{\"cmd\":\"enqueue\", \"name\":\"job3\", \"pri\":0},{\"cmd\":\"enqueue\", \"name\":\"job4\", \"pri\":1},{\"cmd\":\"dequeue\"}]}";
        System.out.println(msg);
        System.out.println("************************************");
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}
