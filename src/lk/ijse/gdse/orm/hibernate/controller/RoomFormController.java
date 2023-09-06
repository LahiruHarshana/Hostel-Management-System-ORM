package lk.ijse.gdse.orm.hibernate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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




}
