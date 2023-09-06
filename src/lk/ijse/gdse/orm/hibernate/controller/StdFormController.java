package lk.ijse.gdse.orm.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.gdse.orm.hibernate.dto.tm.StudentTM;

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

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
    }

    @FXML
    void svBtnOnAction(ActionEvent event) {
    }

    @FXML
    void searchBtnOnCtion(ActionEvent event) {

    }
}
