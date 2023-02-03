package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.Operation;
import Dto.Mobile;
import Dto.Sims;

public class TestUpdate {
	public static void main(String[] args) {
		
		Mobile mobile = new Mobile();
		mobile.setId(1);
		mobile.setModelname("F9");
		
		Sims sims = new Sims();
		sims.setId(1);
		sims.setProvider("jio");
		

		Sims sims2 = new Sims();
		sims2.setId(2);
		sims2.setProvider("jio");

		
		List<Sims> list = new ArrayList<Sims>();
		list.add(sims);
		list.add(sims2);
		
		//Relations one to many;
				mobile.setSims(list);
				
				Operation operation = new Operation();
				operation.update(list);
	}

}
