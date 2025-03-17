package com.zym;

public class WorkOut {

	private String type;
	private String equipment;
	private int weight;
	private int repetitions;
	private String reason;
	
	public WorkOut(String type, String equipment, int weight, int repetitions, String reason) {
		super();
		this.type = type;
		this.equipment = equipment;
		this.weight = weight;
		this.repetitions = repetitions;
		this.reason = reason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "WorkOut [type=" + type + ", equipment=" + equipment + ", weight=" + weight + ", repetitions="
				+ repetitions + ", reason=" + reason + "]";
	}
	
	
}
