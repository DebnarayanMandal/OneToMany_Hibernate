package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.Operation;
import Dto.Mobile;
import Dto.Sims;

public class TestInsert {
	public static void main(String[] args) {
		Mobile mobile = new Mobile();
		mobile.setModelname("note4");
	
		
		Sims sims = new Sims();
		sims.setProvider("Jio");
		
		
		Sims sims2 = new Sims();
		sims2.setProvider("jio");
		
		
		
		List<Sims> list = new ArrayList<Sims>();
		list.add(sims);
		list.add(sims2);
		
		//Relations one to many;
		mobile.setSims(list);
		
		Operation operation = new Operation();
		operation.insert(list);
	}

}
