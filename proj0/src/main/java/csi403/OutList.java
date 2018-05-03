package csi403;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class OutList implements Serializable{
//	public List<String> suggested = new ArrayList<String>();

	public List<List<String>> suggested= new ArrayList();

	public List<List<String>> getSuggested() {
		return suggested;
	}

	public void setSuggested(List<String> names) {
		this.suggested.add(names);
	}




	//
//	public List<String> getSuggested() {
//		return suggested;
//	}
//
//	public void setSuggested(String name) {
//		this.suggested.add(name);
//	}
}
