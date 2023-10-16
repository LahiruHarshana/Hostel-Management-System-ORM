package lk.ijse.gdse.orm.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lk.ijse.gdse.orm.hibernate.bo.BoFactory;
import lk.ijse.gdse.orm.hibernate.bo.custom.ReservationBO;
import lk.ijse.gdse.orm.hibernate.controller.util.CustomAlert;
import lk.ijse.gdse.orm.hibernate.controller.util.Validation;
import lk.ijse.gdse.orm.hibernate.dto.ReservationDTO;
import lk.ijse.gdse.orm.hibernate.dto.RoomDTO;
import lk.ijse.gdse.orm.hibernate.dto.StudentDTO;
import lk.ijse.gdse.orm.hibernate.dto.tm.ReservationTM;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ReservationFormController {
    @FXML
    private TableView<ReservationTM> resTbl;

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

    private final ReservationBO reservationBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.RESERVATION);
    boolean date, sid, rid, sts;

    @FXML
    void addNewBtnOnAction(ActionEvent event) {
        dtPicketr.setDisable(false);
        idCmb.setDisable(false);
        rmIdCmb.setDisable(false);
        stsCmb.setDisable(false);
        svBtn.setDisable(false);
        setResId();
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (reservationBO.deleteRes(idTxt.getText())) {
            new CustomAlert(Alert.AlertType.CONFIRMATION, "Delete ", "Deleted !", "Reservation Deleted successful !").show();
            fillTable();
            initUi();
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Delete ", "Not Deleted !", "Delete not successful !").show();
        }

    }

    @FXML
    void idCmbOnAction(ActionEvent event) {
        StudentDTO studentDTO = reservationBO.getStd(idCmb.getValue());
        stNameTxt.setText(studentDTO.getName());
    }

    @FXML
    void rmIdCmbOnAction(ActionEvent event) {
        RoomDTO roomDTO = reservationBO.getRoom(rmIdCmb.getValue());
        rmTypeTxt.setText(roomDTO.getType());
        kMnyTxt.setText(roomDTO.getKeyMoney());

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        String rid = searchTxt.getText();
        ReservationDTO res = null;
        for (ReservationDTO reservationDTO : reservationBO.getAllReservation()) {
            if (reservationDTO.getResId().equals(rid)) {
                res = new ReservationDTO(
                        reservationDTO.getResId(),
                        reservationDTO.getDate(),
                        reservationDTO.getStdId(),
                        reservationDTO.getRoomId(),
                        reservationDTO.getSts(),
                        reservationDTO.getStdNameTxt(),
                        reservationDTO.getRoomType(),
                        reservationDTO.getKeyMoney()
                );
            }
        }
        if (res != null) {
            svBtn.setDisable(true);
            upBtn.setDisable(false);
            deleteBtn.setDisable(false);
            stsCmb.setDisable(false);
            idCmb.setDisable(false);
            rmIdCmb.setDisable(false);
            dtPicketr.setDisable(false);

            idCmb.getSelectionModel().select(getCmbIndex(idCmb, res.getStdId()));
            rmIdCmb.getSelectionModel().select(getCmbIndex(rmIdCmb, res.getRoomId()));
            stsCmb.getSelectionModel().select(getCmbIndex(stsCmb, res.getSts()));
            idTxt.setText(res.getResId());
            dtPicketr.setValue(res.getDate().toLocalDate());
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Error ", "Invalid", "Invalid Room id !").show();
        }
        searchTxt.clear();
    }

    @FXML
    void searchTxtOnAction(ActionEvent event) {
        searchBtn.fire();

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

    @FXML
    void svBtnOnAction(ActionEvent event) {
        if (validation()) {
            if (reservationBO.saveRes(new ReservationDTO(idTxt.getText(), Date.valueOf(dtPicketr.getValue()), idCmb.getValue(), rmIdCmb.getValue(), stsCmb.getValue(), stNameTxt.getText(), rmTypeTxt.getText(), kMnyTxt.getText()))) {
                new CustomAlert(Alert.AlertType.CONFIRMATION, "Save ", "Saved !", "Reservation Update successful !").show();
                fillTable();
                initUi();
            } else {
                new CustomAlert(Alert.AlertType.ERROR, "Update ", "Not Update !", "Update not successful !").show();
            }
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        if (validation()) {
            if (reservationBO.updateRes(new ReservationDTO(idTxt.getText(), Date.valueOf(dtPicketr.getValue()), idCmb.getValue(), rmIdCmb.getValue(), stsCmb.getValue(), stNameTxt.getText(), rmTypeTxt.getText(), kMnyTxt.getText()))) {
                new CustomAlert(Alert.AlertType.CONFIRMATION, "Update ", "Updated !", "Student Update successful !").show();
                fillTable();
                initUi();
            } else {
                new CustomAlert(Alert.AlertType.ERROR, "Update ", "Not Update !", "Update not successful !").show();
            }
        }
    }

    @FXML
    void initialize() {
        fillTable();
        setRoomIds();
        setStdId();
        setSts();
        initUi();
        setValueFactory();
    }

    private void setResId() {
        idTxt.setText(reservationBO.getNextId());
    }


    private void initUi() {
        idTxt.setDisable(true);
        dtPicketr.setDisable(true);
        idCmb.setDisable(true);
        rmIdCmb.setDisable(true);
        stsCmb.setDisable(true);
        svBtn.setDisable(true);
        upBtn.setDisable(true);
        deleteBtn.setDisable(true);

        dtPicketr.setValue(null);
        idCmb.setValue(null);
        rmIdCmb.setValue(null);
        stsCmb.setValue(null);
        idTxt.clear();
        stNameTxt.setText("");
        rmTypeTxt.setText("");
        kMnyTxt.setText("");
    }


    private void setValueFactory() {
        reIdColm.setCellValueFactory(new PropertyValueFactory<>("resId"));
        stIdColm.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        rmColm.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        stNameColm.setCellValueFactory(new PropertyValueFactory<>("stdName"));
        kyMoneyColm.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        dateColm.setCellValueFactory(new PropertyValueFactory<>("date"));
        epireDtColm.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        stsColm.setCellValueFactory(new PropertyValueFactory<>("sts"));
    }

    private void setSts() {
        stsCmb.getItems().setAll("Paid", "Not-Paid");
    }


    private void setStdId() {
        ObservableList<String> stdIdList = FXCollections.observableArrayList();
        stdIdList.addAll(reservationBO.getStdId());
        idCmb.setItems(stdIdList);
    }


    private void setRoomIds() {
        ObservableList<String> roomIdList = FXCollections.observableArrayList();
        roomIdList.addAll(reservationBO.getRoomIds());
        rmIdCmb.setItems(roomIdList);
    }


    private void fillTable() {
        ObservableList<ReservationTM> reservationTMS = FXCollections.observableArrayList();
        for (ReservationDTO reservationDTO : reservationBO.getAllReservation()) {
            reservationTMS.add(new ReservationTM(
                    reservationDTO.getResId(),
                    reservationDTO.getRoomId(),
                    reservationDTO.getStdId(),
                    reservationDTO.getStdNameTxt(),
                    reservationDTO.getDate(),
                    reservationDTO.getKeyMoney(),
                    reservationDTO.getSts(),
                    genarateExpDate(reservationDTO.getDate().toLocalDate())
            ));
        }
        resTbl.setItems(reservationTMS);
    }

    private boolean validation() {
        date = false;
        sid = false;
        rid = false;
        sts = false;
        date = Validation.dateValidation(dtPicketr);
        sid = Validation.comboValidation(idCmb);
        rid = Validation.comboValidation(rmIdCmb);
        sts = Validation.comboValidation(stsCmb);
        return date && sid && rid && sts;
    }

    private Date genarateExpDate(LocalDate date) {
        LocalDate genDate = date.plusMonths(1);
        return Date.valueOf(genDate);
    }


}
