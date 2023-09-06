package lk.ijse.gdse.orm.hibernate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class StdFormController {
    @FXML
    private Button addBtn1;

    @FXML
    private TableColumn<?, ?> addressColm;


    @FXML
    private TextField addressTxt;

    @FXML
    private TableColumn<?, ?> contactColm;


    @FXML
    private TextField contactTxt;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> dobColm;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TableColumn<?, ?> genColm;


    @FXML
    private TextField genTxt;

    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<?, ?> nameColm;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField searchTxt;
    @FXML
    private Button searchBtn;

    @FXML
    private TableView<StudentTM> stdTbl;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;
}
