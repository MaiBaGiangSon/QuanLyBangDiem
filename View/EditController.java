package View;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import Model.Student;
import application.ConnectSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EditController{
	@FXML
	private TextField tfFirstName;
	@FXML
	private TextField tfLastName;
	@FXML
	private TextField tfLy;
	@FXML
	private TextField tfToan;
	@FXML
	private TextField tfMa;
	@FXML
	private TableView<Student> ListTable;
	@FXML
	private TableColumn<Student, String> NoColumn;
	@FXML
	private TableColumn<Student, String> HoColumn;
	@FXML
	private TableColumn<Student, String> TenColumn;
	@FXML
	private TableColumn<Student, String> LopColumn;
	@FXML
	private TableColumn<Student, String> QueColumn;
	@FXML
	private Label lbMa;
	private Student st;
	private static Student StSelect;
	private Stage dialogStage;
	ConnectSQL contact = new ConnectSQL();
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public static void setStudentSelect(Student st) {	//Hàm này để trả về mã cũ của SV được chọn
		StSelect = st;									//Lấy đó làm điều kiện để cập nhật ở hàm Edit trong class ConnectSQL
	}
	public void ShowDetails(Student st) {
		this.st = st;
		tfFirstName.setText(st.getFirstName());//Show ra các textfield các giá trị cũ để Edit
		tfLastName.setText(st.getLastName());
		//		tfAve.setText(st.getAve());
		tfLy.setText(String.valueOf(st.getLy()));
		tfToan.setText(String.valueOf(st.getToan()));
		tfMa.setDisable(true);				//Disable tfMa để không sửa được
		tfMa.setText(st.getQuyen());
	}
	public void Edit() {
		String FirstName = tfFirstName.getText();//nhập vào các textfield các giá trị
		double Ly = Double.parseDouble(tfLy.getText().toString());
		double Toan = Double.parseDouble(tfToan.getText().toString());
		String LastName = tfLastName.getText();

		String Ma = tfMa.getText();
		ConnectSQL connect = new ConnectSQL();
		Student stnew = new Student();
		stnew.setFirstName(FirstName);
		stnew.setLastName(LastName);
		stnew.setLy(Ly);
		stnew.setToan(Toan);
		stnew.setQuyen(Ma);
		connect.Edit(stnew,StSelect);
	}
}
