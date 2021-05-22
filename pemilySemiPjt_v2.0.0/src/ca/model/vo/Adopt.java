package ca.model.vo;

import inca.model.vo.Inca;

public class Adopt {
	private Inca inca;
	private Ca ca;
	public Adopt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adopt(Inca inca, Ca ca) {
		super();
		this.inca = inca;
		this.ca = ca;
	}
	public Inca getInca() {
		return inca;
	}
	public void setInca(Inca inca) {
		this.inca = inca;
	}
	public Ca getCa() {
		return ca;
	}
	public void setCa(Ca ca) {
		this.ca = ca;
	}

}
