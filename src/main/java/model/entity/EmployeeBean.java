package model.entity;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private int id;
	private String name;
	private String homeTown;
	//引数無しコンストラクタを定義。
	public EmployeeBean() {
		//処理なし
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
}
