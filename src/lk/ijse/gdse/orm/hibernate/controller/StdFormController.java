package lk.ijse.gdse.orm.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.orm.hibernate.bo.BoFactory;
import lk.ijse.gdse.orm.hibernate.bo.custom.StudentBO;
import lk.ijse.gdse.orm.hibernate.controller.util.CustomAlert;
import lk.ijse.gdse.orm.hibernate.controller.util.Validation;
import lk.ijse.gdse.orm.hibernate.dto.StudentDTO;
import lk.ijse.gdse.orm.hibernate.dto.tm.StudentTM;

import java.sql.Date;
import java.util.List;

public class StdFormController {

    @FXML
    private ComboBox<String> genCmb;
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

    private final StudentBO studentBO= BoFactory.getInstance().getBo(BoFactory.BOTypes.STUDENT);

    boolean id, name, gen, dob, contact, address;


    @FXML
    void initialize(){
        initUi();
        setCellValueFactory();
        fillTable();
        setValueGeneration();
    }



    private void fillTable() {
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentBO.getAll()) {
            studentTMS.add(new StudentTM(
                    studentDTO.getsId(),
                    studentDTO.getName(),
                    studentDTO.getDob(),
                    studentDTO.getContact(),
                    studentDTO.getAddress(),
                    studentDTO.getGen())
            );
        }
        stdTbl.setItems(studentTMS);
    }

    private void setCellValueFactory() {
        idColm.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColm.setCellValueFactory(new PropertyValueFactory<>("name"));
        genColm.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dobColm.setCellValueFactory(new PropertyValueFactory<>("dob"));
        contactColm.setCellValueFactory(new PropertyValueFactory<>("contact"));
        addressColm.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void initUi(){
        idTxt.clear();
        nameTxt.clear();
        dobPicker.setValue(null);
        contactTxt.clear();
        addressTxt.clear();
        idTxt.setDisable(true);
        nameTxt.setDisable(true);
        dobPicker.setDisable(true);
        contactTxt.setDisable(true);
        addressTxt.setDisable(true);
        deleteBtn.setDisable(true);
        upBtn.setDisable(true);
        svBtn.setDisable(true);
    }

    private void setValueGeneration() {
        genCmb.getItems().setAll("Male", "Female", "Potato");
    }
    @FXML
    void addNewBtnOnAction(ActionEvent event) {
        idTxt.setDisable(false);
        nameTxt.setDisable(false);
        genCmb.setDisable(false);
        dobPicker.setDisable(false);
        contactTxt.setDisable(false);
        addressTxt.setDisable(false);
        idTxt.requestFocus();
        svBtn.setDisable(false);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (studentBO.deleteStd(idTxt.getText())){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Student Deleted successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Deleted !","Delete not successful !").show();
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        if (studentBO.updateStd(new StudentDTO(idTxt.getText(),nameTxt.getText(),addressTxt.getText(),contactTxt.getText(), Date.valueOf(dobPicker.getValue()),genCmb.getValue()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }

    @FXML
    void svBtnOnAction(ActionEvent event) {
        if (studentBO.saveStd(new StudentDTO(idTxt.getText(),nameTxt.getText(),addressTxt.getText(),contactTxt.getText(),Date.valueOf(dobPicker.getValue()),genCmb.getValue()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }

    @FXML
    void searchBtnOnCtion(ActionEvent event) {
        String sid=idTxt.getText();
        StudentDTO studentDTO=studentBO.getStudent(sid);
        if (studentDTO!=null){
            svBtn.setDisable(true);
            upBtn.setDisable(false);
            deleteBtn.setDisable(false);
            idTxt.setDisable(true);
            nameTxt.setDisable(false);
            genCmb.setDisable(false);
            dobPicker.setDisable(false);
            contactTxt.setDisable(false);
            addressTxt.setDisable(false);
            idTxt.requestFocus();

            idTxt.setText(studentDTO.getsId());
            nameTxt.setText(studentDTO.getName());
            genCmb.getSelectionModel().select(getCmbIndex(genCmb, studentDTO.getGen()));
            dobPicker.setValue(studentDTO.getDob().toLocalDate());
            contactTxt.setText(studentDTO.getContact());
            addressTxt.setText(studentDTO.getAddress());
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Error ","Invalid","Invalid student id !").show();
        }
        searchTxt.clear();
    }

    int getCmbIndex(ComboBox<String> cmb, String value) {
        List<String> cmbList = cmb.getItems();
        for (int i = 0; i < cmbList.size(); i++) {
            if (cmbList.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }
    private boolean validate() {
        id = false;
        name = false;
        gen = false;
        dob = false;
        contact = false;
        address = false;
        id = Validation.txtValidation(idTxt);
        name = Validation.txtValidation(nameTxt);
        gen = Validation.comboValidation(genCmb);
        dob = Validation.dateValidation(dobPicker);
        contact = Validation.txtValidation(contactTxt);
        address = Validation.txtValidation(addressTxt);
        contact = Validation.cNumValidation(contactTxt);
        if (id && name && gen && dob && contact && address) {
            return true;
        }
        return false;
    }

}
