package Model;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class Student {
	private String STT;
	private String FirstName;
	private String LastName;
	private String FullName;
	private double Toan;
	private double Ly ;
	private double Ave;
	private String NickName;
	private String Range;
	private String Quyen;
	public Student() {
	}
	public String getSTT() {
		return STT;
	}
	public void setSTT(String sTT) {
		STT = sTT;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFullName() {
		return FirstName+LastName;
	}
	public void setFullName(String fullName) {
		this.FullName = FirstName+"  "+LastName;
	}
	public double getToan() {
		return Toan;
	}
	public void setToan(double toan) {
		Toan = toan;
	}
	public double getLy() {
		return Ly;
	}
	public void setLy(double ly) {
		Ly = ly;
	}
	public double getAve() {
		return (Toan+Ly)/2;
	}
	public void setAve(double Ave) {
		this.Ave = (Toan+Ly)/2;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getRange() {
		String hl="Giỏi";
		if(getAve()<5) {
			return	hl="Yếu";
		}
		if(getAve()>5&&getAve()<8) {
			return hl="Giỏi";
		}
		if(getAve()>8) {
			 return hl="Xuất sắc";	
		}
		return hl;
	}
	public void setRange(String Range) {
		this.Range=Range;
	}
	public String getQuyen() {
		return Quyen;
	}
	public void setQuyen(String quyen) {
		Quyen = quyen;
	}
	
	
}
