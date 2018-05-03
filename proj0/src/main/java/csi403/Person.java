package csi403;

import java.util.ArrayList;

public class Person {
	public int id;
	public String name;
	public ArrayList<String> friendShip = new ArrayList<String>();
	
	public Person() {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getFriendShip() {
		return friendShip;
	}
	public void addFriend(String name) {
		this.friendShip.add(name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
