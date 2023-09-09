package lk.ijse.gdse.orm.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ReservationFormController {
    @FXML
    private TableView<?> resTbl;

    @FXML
    private TableColumn<?, ?> reIdColm;

    @FXML
    private TableColumn<?, ?> stIdColm;

    @FXML
    private TableColumn<?, ?> rmColm;

    @FXML
    private TableColumn<?, ?> stNameColm;

    @FXML
    private TableColumn<?, ?> kyMoneyColm;

    @FXML
    private TableColumn<?, ?> dateColm;

    @FXML
    private TableColumn<?, ?> epireDtColm;

    @FXML
    private TableColumn<?, ?> stsColm;

    @FXML
    private Button addBtn;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private JFXTextField idTxt;

    @FXML
    private JFXTextField searchTxt;

    @FXML
    private Button searchBtn;

    @FXML
    private DatePicker dtPicketr;

    @FXML
    private ComboBox<String> stsCmb;

    @FXML
    private ComboBox<String> rmIdCmb;

    @FXML
    private ComboBox<String> idCmb;

    @FXML
    private Text stNameTxt;

    @FXML
    private Text kMnyTxt;

    @FXML
    private Text rmTypeTxt;

    @FXML
    void addNewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void idCmbOnAction(ActionEvent event) {

    }

    @FXML
    void rmIdCmbOnAction(ActionEvent event) {

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void searchTxtOnAction(ActionEvent event) {

    }

    @FXML
    void svBtnOnAction(ActionEvent event) {

    }

    @FXML
    void upBtnOnAction(ActionEvent event) {

    }


}
