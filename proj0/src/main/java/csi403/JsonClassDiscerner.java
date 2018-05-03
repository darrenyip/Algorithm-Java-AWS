package csi403; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.List; 
import java.util.ArrayList;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList friendList = new ArrayList();
        
        
        try { 
        	InList inList = mapper.readValue(jsonStr, InList.class);
        	boolean check = false;
        	for(int i = 0; i < inList.getInList().size();i++){
        		check = friendList.contains(inList.getInList().get(i).getFriends().get(0));
        		if(check!= true){
        			friendList.add(inList.getInList().get(i).getFriends().get(0));
        		}
        		check = friendList.contains(inList.getInList().get(i).getFriends().get(1));
        		if(check!=true){
        			friendList.add(inList.getInList().get(i).getFriends().get(1));
        		}
        	}
        	
        	System.out.println(friendList);
        	List<Person> obj = new ArrayList<Person>();
        	for(int i = 0; i < friendList.size();i++){
        		Person info = new Person();
        		info.setName(friendList.get(i).toString());
        		info.setId(i); 
        		obj.add(info);
        	}
        	for(int i = 0; i< inList.getInList().size();i++){
        		int first, second;
        		String one, two;
        		one = (String) inList.getInList().get(i).getFriends().get(0);
        		two = (String) inList.getInList().get(i).getFriends().get(1);
        		first = friendList.indexOf(inList.getInList().get(i).getFriends().get(0));
            	second = friendList.indexOf(inList.getInList().get(i).getFriends().get(1));
            	System.out.println(inList.getInList().get(i).getFriends().get(1).toString());
            	obj.get(first).addFriend(two);
            	obj.get(second).addFriend(one);
        	}
        	
        	
        	
        	List<OutList> outList = new ArrayList<OutList>();
        	for(int i = 0 ; i <  obj.size();i++){
        		for(int j =0;j<obj.get(i).getFriendShip().size();j++){
        			String[] myArray= new String[2];
        			myArray[0] = obj.get(i).getName();
        			myArray[1] = obj.get(i).getFriendShip().get(j).toString();
        		}
        		
        	}
        	
        	
        	
        	
//        	int first, second;
//        	for(int i = 0; i < inList.getInList().size();i++){
//            	first = friendList.indexOf(inList.getInList().get(i).getFriends().get(0));
//            	second = friendList.indexOf(inList.getInList().get(i).getFriends().get(1));
//            	System.out.println("first = "+first+" second =  "+ second);
//            }
//        	
        	
        	
        	
//        	
//        	
//            //Joining part
//        	int n = friendList.size();
//            DisjointUnionSets friends = new DisjointUnionSets(n);
//            int first, second;
//            for(int i = 0; i < inList.getInList().size();i++){
//            	first = friendList.indexOf(inList.getInList().get(i).getFriends().get(0));
//            	second = friendList.indexOf(inList.getInList().get(i).getFriends().get(1));
//            	System.out.println("first = "+first+" second =  "+ second);
//            	friends.union(first, second);
//            }
//            //friend check
//            for(int x = 0; x<(n-1);x++){
//            	for(int y = x+1;y<n;y++){
//            		if(friends.find(x) == friends.find(y)){
//            			System.out.println(friendList.get(x)+" is friend of "+ friendList.get(y));
//            		}else System.out.println(friendList.get(x)+" is not a friend of "+ friendList.get(y));
//            	}
//            }
//        	
        	
        	
        	
            
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
       
        return "<unknown>"; 
    }


    // test app 
    public static void main(String[] args) {

    	String msg;
    	JsonClassDiscerner discerner = new JsonClassDiscerner();

        System.out.println("************************************");
        msg = "{\"inList\":[{\"friends\":[\"Albert\", \"Betty\"]}, {\"friends\":[\"Denis\", \"Albert\"]} , {\"friends\":[\"Cathy\", \"Denis\"]},{\"friends\":[\"Betty\", \"Cathy\"]},{\"friends\":[\"Tony\", \"Bruce\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"friends\":[\"Albert\", \"Betty\"]}, {\"friends\":[\"Betty\", \"Cathy\"]}, {\"friends\":[\"Cathy\", \"Tony\"]}, {\"friends\":[\"Tony\", \"Bruce\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"friends\":[\"A\", \"B\"]}, {\"friends\":[\"A\", \"C\"]}, {\"friends\":[\"C\", \"D\"]}, {\"friends\":[\"D\", \"E\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"friends\":[\"A\", \"B\"]}, {\"friends\":[\"C\", \"D\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        msg = "{\"inList\":[{\"friends\":}, {\"friends\":[\"C\", \"D\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
        
    }
}
