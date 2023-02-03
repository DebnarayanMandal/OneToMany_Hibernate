package Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Mobile {
	@Id
	@Column(name = "MobileId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column(name = "MobileModel")
	private String modelname;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)//all use for not need to multiple time write persist;
	private List<Sims> sims;// here multiple insert;
	
	
	
	public List<Sims> getSims() {
		return sims;
	}
	public void setSims(List<Sims> sims) {
		this.sims = sims;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	
	

}
