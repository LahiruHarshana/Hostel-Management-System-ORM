package lk.ijse.gdse.orm.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lk.ijse.gdse.orm.hibernate.bo.BoFactory;
import lk.ijse.gdse.orm.hibernate.bo.custom.RoomBO;
import lk.ijse.gdse.orm.hibernate.controller.util.CustomAlert;
import lk.ijse.gdse.orm.hibernate.controller.util.Validation;
import lk.ijse.gdse.orm.hibernate.dto.RoomDTO;
import lk.ijse.gdse.orm.hibernate.dto.tm.RoomTM;

public class RoomFormController {
    @FXML
    private Button addBtn1;
    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private Text idTxt;

    @FXML
    private TextField keyMoneyTxt;

    @FXML
    private TableColumn<?, ?> kyMoneyColm;

    @FXML
    private TableColumn<?, ?> qtyColm;
    @FXML
    private TextField qtyTxt;
    @FXML
    private TableView<RoomTM> rmTbl;

    @FXML
    private TextField roomIdTxt;

    @FXML
    private TextField roomTypeTxt;

    @FXML
    private Button searchBtn;

    @FXML
    private Button svBtn;

    @FXML
    private TableColumn<?, ?> typeColm;

    @FXML
    private Button upBtn;

    private final RoomBO roomBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.ROOM);
    boolean id, type, qty, keyMoney;
    @FXML
    void initialize() {
        initUi();
        setCellValueFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();
        for (RoomDTO roomDTO : roomBO.getAll()) {
            roomTMS.add(new RoomTM(
                    roomDTO.getId(),
                    roomDTO.getType(),
                    roomDTO.getQty(),
                    roomDTO.getKeyMoney())
            );
        }
        rmTbl.setItems(roomTMS);
    }

    private void setCellValueFactory() {
        idColm.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeColm.setCellValueFactory(new PropertyValueFactory<>("type"));
        qtyColm.setCellValueFactory(new PropertyValueFactory<>("qty"));
        kyMoneyColm.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
    }

    private void initUi() {
        roomIdTxt.clear();
        roomTypeTxt.clear();
        qtyTxt.clear();
        keyMoneyTxt.clear();

        roomIdTxt.setDisable(true);
        roomTypeTxt.setDisable(true);
        qtyTxt.setDisable(true);
        keyMoneyTxt.setDisable(true);

        svBtn.setDisable(true);
        upBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }

    @FXML
    void qtyTxtOnAction(ActionEvent event) {
        keyMoneyTxt.requestFocus();
    }

    @FXML
    void roomIdTxtOnAction(ActionEvent event) {
        roomTypeTxt.requestFocus();
    }

    @FXML
    void roomTypeOnAction(ActionEvent event) {
        qtyTxt.requestFocus();
    }

    @FXML
    void searchTxtOnAction(ActionEvent event) {
        searchBtn.fire();
    }

    @FXML
    void searchBtnOnCtion(ActionEvent event) {
        String rid=roomIdTxt.getText();
        RoomDTO roomDTO=roomBO.getRoom(rid);
        if (roomDTO!=null){
            roomIdTxt.setText(roomDTO.getId());
            roomTypeTxt.setText(roomDTO.getType());
            qtyTxt.setText(String.valueOf(roomDTO.getQty()));
            keyMoneyTxt.setText(roomDTO.getKeyMoney());
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Error ","Invalid","Invalid Room id !").show();
        }
    }

    @FXML
    void svBtnOnAction(ActionEvent event) {
        validation();
        if (roomBO.saveRoom(new RoomDTO(roomIdTxt.getText(),roomTypeTxt.getText(),Integer.parseInt(qtyTxt.getText()),keyMoneyTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Room Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        validation();
        if (roomBO.updateRoom(new RoomDTO(roomIdTxt.getText(),roomTypeTxt.getText(),Integer.parseInt(qtyTxt.getText()),keyMoneyTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }
    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (roomBO.deleteRoom(roomIdTxt.getText())){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Room Deleted successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Deleted !","Delete not successful !").show();
        }
    }
    @FXML
    void addNewBtnOnAction(ActionEvent event) {
        roomIdTxt.setDisable(false);
        roomTypeTxt.setDisable(false);
        qtyTxt.setDisable(false);
        keyMoneyTxt.setDisable(false);
        svBtn.setDisable(false);
        idTxt.requestFocus();
    }
    private void validation() {
        id=false;
        type=false;
        qty=false;
        keyMoney=false;
        id= Validation.txtValidation(roomIdTxt);
        type=Validation.txtValidation(roomTypeTxt);
        qty=Validation.txtValidation(qtyTxt);
        keyMoney=Validation.txtValidation(keyMoneyTxt);
    }

}
