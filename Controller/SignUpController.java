package Controller;

import Model.Login;
import Model.SignUp;
import Model.Student;
import application.ConnectSQL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	@FXML
	private TextField tfHoten;
	@FXML
	private TextField tfUser;
	@FXML
	private PasswordField tfPass;
	@FXML
	private TextField tfMail;
	@FXML
	private Button btOK;
	public void OK() {
		String Hoten = tfHoten.getText();
		String User = tfUser.getText();
		String Pass = tfPass.getText();
		String Mail = tfMail.getText();
		ConnectSQL connect = new ConnectSQL();
		Login su = new Login();
//		su.setHoten(Hoten);
		su.setUserr(User);
		su.setPass(Pass);
//		su.setMail(Mail);
		connect.ThemUser(su);
	}
}
