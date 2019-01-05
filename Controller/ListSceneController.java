package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.Student;
import View.EditController;
import application.ConnectSQL;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ListSceneController implements Initializable {
	@FXML
	private TableView<Student> ListTable;
	@FXML
	private TableColumn<Student, String> NoColumn;
	@FXML
	private TableColumn<Student, String> NameColumn;
	@FXML
	private TableColumn<Student, String> AveColumn;
	@FXML
	private TableColumn<Student, String> NickColumn;
	@FXML
	private TableColumn<Student, String> RangeColumn;
	@FXML
	private TableColumn<Student, String> QuyenColumn;
	@FXML
	private Label NameLabel;
	@FXML
	private Label AveLabel;
	@FXML
	private Label NickLabel;
	@FXML
	private Label RangeLabel;
	@FXML
	private Label QuyenLabel;
	@FXML
	private Label MaLabel;
	@FXML
	private Button btThem;
	@FXML
	private Button btEdit;
	@FXML
	private Button btPlay;
	@FXML
    private MenuItem handleExitItem;
	@FXML
	private Button btRe;
    @FXML
	public static Stage NewStage;
	public static Stage EditStage;
	private Student st;
	private static Student StSelect;
	public static void setStudentSelect(Student st) {
		StSelect = st;
	}
	public ListSceneController() {
	}
	ConnectSQL contact = new ConnectSQL();
	public List<Student> getDocGia(){
		List<Student> list = contact.getDocGia();
		ObservableList<Student> docgia = FXCollections.observableArrayList(list);
		return list;
	}	
	//Tạo nút sự kiện cho nút Edit
	public boolean Edit11(Student st) {//Hàm nàyy để kiểm tra xem có sinh viên nào được chọn hay chưa,
		try {						//Nếu đã chọn 1 sinh viên thì show ra giao diện Edit
			FXMLLoader loader = new FXMLLoader();	
			int selectIndex = ListTable.getSelectionModel().getSelectedIndex();
			if(selectIndex>=0) {
				loader.setLocation(Main.class.getResource("../View/EditStudent.fxml")); //Địa chỉ load giao diện
				AnchorPane 	page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				Stage EditStage = new Stage();
				EditStage.setScene(scene);
				EditStage.setTitle("Edit Student");	
				EditStage.initModality(Modality.WINDOW_MODAL);		
				EditController controller = loader.getController();
				controller.setDialogStage(EditStage);
				EditController.setStudentSelect(ListTable.getSelectionModel().getSelectedItem());
				controller.ShowDetails(ListTable.getSelectionModel().getSelectedItem());
				this.EditStage = EditStage;
				EditStage.show();	
		}
		else {//Thông báo chưa có sinh viên nào được chọn
			 Alert alert = new Alert(AlertType.WARNING);
//		     alert.initOwner(mainApp.getPrimaryStage());
		     alert.setTitle("No Selection");
		     alert.setHeaderText("No Person Selected");
		     alert.setContentText("Please select a person in the table.");

		     alert.showAndWait();
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
}
	public void Edit(ActionEvent event) throws IOException{
		Edit11(st);
	}
	//Tạo nút sự kiện cho nút Delete
	public void Xoa() {
			int select = ListTable.getSelectionModel().getSelectedIndex(); //Chọn ra Sinh viên
			if(select>=0) {		//Nếu đã chọn >1 sinh viên thì xóa, còn không thì thông báo không có Sinh viên được chọn
				Student st = new Student();
				st = ListTable.getItems().remove(select);
				ConnectSQL connect = new ConnectSQL();
				connect.Xoa(st);
			}
			else {
				 Alert alert = new Alert(AlertType.WARNING);
			     alert.setTitle("No Selection");
			     alert.setHeaderText("No Person Selected");
			     alert.setContentText("Please select a person in the table.");

			     alert.showAndWait();
			}
	}
	//Code của Button Logout
	public void Logout() throws IOException {
		ConnectSQL.DanhsachStage.close();
		Parent Danhsachfxml = FXMLLoader.load(getClass().getClassLoader().getResource("View/LoginScene.fxml"));
		Scene DanhsachScene = new Scene(Danhsachfxml);
		Stage DanhsachStage = new Stage();
		DanhsachStage.setScene(DanhsachScene);
		DanhsachStage.setTitle("Ä�Äƒng nháº­p");
		DanhsachStage.initModality(Modality.WINDOW_MODAL);
		DanhsachStage.initOwner(Main.primaryStage);
		DanhsachStage.show();
		
	}
	//Code của Button Exit
	public void Close(ActionEvent event) {   	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Alert");
		alert.setHeaderText("Do you want to quit ?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    System.exit(0);
		} else {
		    alert.hide();
		}
	    }
	//Code ham Refresh
	public void Refresh() throws IOException {
		ConnectSQL.DanhsachStage.hide();
		Parent Danhsachfxml = FXMLLoader.load(getClass().getClassLoader().getResource("View/ListScene.fxml"));
		Scene DanhsachScene = new Scene(Danhsachfxml);
		Stage DanhsachStage = new Stage();
		DanhsachStage.setScene(DanhsachScene);
		DanhsachStage.setTitle("Danh sách sinh viên !");
		DanhsachStage.initModality(Modality.WINDOW_MODAL);
		DanhsachStage.initOwner(Main.primaryStage);
		DanhsachScene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		DanhsachStage.show();
	}
	public void initialize(URL location, ResourceBundle resource) {
		NoColumn.setCellValueFactory(new PropertyValueFactory<>("STT"));
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("FullName"));
		AveColumn.setCellValueFactory(new PropertyValueFactory<>("Ave"));
		NickColumn.setCellValueFactory(new PropertyValueFactory<>("NickName"));
		RangeColumn.setCellValueFactory(new PropertyValueFactory<>("Range"));
		ListTable.getItems().setAll(getDocGia());
		handleExitItem.setAccelerator(new KeyCodeCombination(KeyCode.X,KeyCombination.CONTROL_DOWN));
	}
}
