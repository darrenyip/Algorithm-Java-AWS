package csi403; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList friendList = new ArrayList();
        JsonSerializer serializer = new JsonSerializer();
        
        
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
            	obj.get(first).addFriend(two);
            	obj.get(second).addFriend(one);
        	}
        	//test
//			for(int i = 0; i < friendList.size();i++){
//				System.out.println(obj.get(i).getName()+" has friends = "+obj.get(i).getFriendShip());
//			}
        	
        	
        	
			OutList suggested = new OutList();
        	List<List<String>> compare = new ArrayList<List<String>>();

        	for(int i = 0 ; i <  obj.size();i++){
        		for(int j =0;j<obj.get(i).getFriendShip().size();j++){

        			String levelOne = obj.get(i).getFriendShip().get(j);
        			int indexOfLevelOne = friendList.indexOf(levelOne);


					for(int k =0; k< obj.get(indexOfLevelOne).friendShip.size();k++){
						List<String> myString = new ArrayList<String>();
						String f = obj.get(i).getName().toString();
						myString.add(f);
						String foaf = obj.get(indexOfLevelOne).friendShip.get(k).toString();
						myString.add(foaf);

						compare.add(myString);

						boolean same = false;
						same  = f.equals(foaf);

						for(int x =0;x<compare.size();x++){
							boolean check1, check2;
							check1 = f.equals(compare.get(x).get(0)) && foaf.equals(compare.get(x).get(1));
							check2 = f.equals(compare.get(x).get(1)) && foaf.equals(compare.get(x).get(0));
							if(same == false ){
								if(check2 == false && check1 == false){
									suggested.setSuggested(myString);
									break;
								}

							}
						}

//
//						if(same == false)
//							suggested.setSuggested(myString);
					}
				}
        	}


			System.out.println("--------------");
        	for(int i =0; i< compare.size();i++){
				System.out.println(compare.get(i).get(0)+"and"+ compare.get(i).get(1));

			}


			System.out.println(compare);


			return serializer.serialize(suggested);



        	
            
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
       

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
        msg = "{\"inList\":[{\"friends\":[\"Albert\", \"Betty\"]}, {\"friends\":[\"Betty\", \"Cathy\"]}, {\"friends\":[\"Cathy\", \"Denis\"]}, {\"friends\":[\"Denis\", \"Albert\"]}, {\"friends\":[\"Tony\", \"Bruce\"]}]}";
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
