package Controller;

import java.io.IOException;

import javax.print.attribute.standard.MediaSize.Engineering;

import Model.Login;

import Model.Student;
import application.ConnectSQL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField tfUser;
	@FXML 
	private PasswordField tfPass;
	@FXML
	private Button btLogin;
	@FXML
	private Button btDangKy;
	@FXML
	private Hyperlink Facelink;
	public static Stage NewStage;
	private Student su;
	public void Login() {
		
		String user = tfUser.getText();
		String pass = tfPass.getText();
		if(user.isEmpty() || pass.isEmpty()) {
			
		}
		Login login = new Login();
		ConnectSQL connect = new ConnectSQL();
		login.setUserr(user);
		login.setPass(pass);
		connect.Login(login);
	}
	@FXML
	private TextField tfHoten;
//	@FXML
//	private TextField tfUser;
//	@FXML
//	private PasswordField tfPass;
	@FXML
	private TextField tfMail;
	
	public void DangKy(ActionEvent event) throws IOException {
		try {
		Parent NewScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("View/SignUpScene.fxml"));
		Scene NewScene = new Scene(NewScenefxml);
		Stage NewStage = new Stage();
		NewStage.setScene(NewScene);
		NewStage.setTitle("Tạo quản trị viên !");		
		NewStage.initModality(Modality.WINDOW_MODAL);
		this.NewStage = NewStage;
		NewStage.show();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
