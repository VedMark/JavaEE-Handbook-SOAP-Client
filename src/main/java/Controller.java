import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.TableColumn.CellEditEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.ws.axis2.J2EeHandbookServiceStub.JavaEETechnology;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private final String DEFAULT_RPC_SERVER = "";
    private final String DEFAULT_SOAP_SERVER = "http://localhost:8080/axis2/services/J2EeHandbookService?wsdl";
    private String serverAdress = "";

    private static final Logger log = LogManager.getLogger(HandbookClientApp.class);
    private ProtocolPerformer performer = new SoapProtocolPerformer();

    @FXML
    TableView<JavaEETechnology> javaTechnologiesTable;
    @FXML
    TableColumn iName;
    @FXML
    TableColumn iVForJava4;
    @FXML
    TableColumn iVForJava5;
    @FXML
    TableColumn iVForJava6;
    @FXML
    TableColumn iVForJava7;
    @FXML
    TableColumn iVForJava8;
    @FXML
    TableColumn iDescription;

    private final ObservableList<JavaEETechnology> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Callback<TableColumn, TableCell> cellFactory = p -> new EditingCell(this);

        iName.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("name"));
        iName.setCellFactory(cellFactory);
        iName.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                t.getTablePosition().getRow()).setName(t.getNewValue())
        );
        iVForJava4.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava4"));
        iVForJava4.setCellFactory(cellFactory);
        iVForJava4.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setVersionForJava4(t.getNewValue())
        );
        iVForJava5.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava5"));
        iVForJava5.setCellFactory(cellFactory);
        iVForJava5.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setVersionForJava5(t.getNewValue())
        );
        iVForJava6.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava6"));
        iVForJava6.setCellFactory(cellFactory);
        iVForJava6.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setVersionForJava6(t.getNewValue())
        );
        iVForJava7.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava7"));
        iVForJava7.setCellFactory(cellFactory);
        iVForJava7.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setVersionForJava7(t.getNewValue())
        );
        iVForJava8.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava8"));
        iVForJava8.setCellFactory(cellFactory);
        iVForJava8.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setVersionForJava8(t.getNewValue())
        );
        iDescription.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("description"));
        iDescription.setCellFactory(cellFactory);
        iDescription.setOnEditCommit(
                (EventHandler<CellEditEvent<JavaEETechnology, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setDescription(t.getNewValue())
        );

        javaTechnologiesTable.setItems(data);

        showProtocolDialog();
        showConnectionDialog();
        getAllData();
    }

    void getAllData() {
        JavaEETechnology[] technologies = performer.getAllTechnologies();
        if(technologies != null) {
            data.clear();
            data.addAll(technologies);
        }
    }

    void addRow(JavaEETechnology technology) {
        performer.insert(technology);
    }

    void removeRow(JavaEETechnology technology) {
        performer.delete(technology);
    }

    void updateRow(JavaEETechnology technology) {
        performer.update(technology);
    }

    @FXML
    private void handleSynchronizeAction() {
        getAllData();
    }

    @FXML
    private void handleConnectAction() {
        showProtocolDialog();
        showConnectionDialog();
        getAllData();
    }

    @FXML
    private void handleRpcAction() {
    }

    @FXML
    private void handleSoapAction() {
        performer = new SoapProtocolPerformer();
    }

    @FXML
    private void handleAddAction() {
        showAddDialog();
    }

    private void showAddDialog() {
        InsertDialog dialog;
        try {
            dialog = new InsertDialog((Stage) javaTechnologiesTable.getScene().getWindow(), this);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            showErrorAlert(
                    "Error with add dialog",
                    "Exception occurred while loading dialog window!"
            );
        }
    }

    @FXML
    private void handleRemoveAction() {
        removeRow(javaTechnologiesTable.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleUpdateAction() {
        updateRow(javaTechnologiesTable.getSelectionModel().getSelectedItem());
    }

    private void showProtocolDialog() {
        List<String> choices = new ArrayList<>();
        choices.add("RPC");
        choices.add("SOAP");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("RPC", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Protocol");
        dialog.setContentText("Choose a protocol:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(protocol -> {
            if (protocol.equals("RPC")) {
                serverAdress = DEFAULT_RPC_SERVER;
            }
            else {
                serverAdress = DEFAULT_SOAP_SERVER;
                performer = new SoapProtocolPerformer();
            }
        });
    }

    private void showConnectionDialog() {
        TextInputDialog dialog = new TextInputDialog(serverAdress);
        dialog.setTitle("Connect");
        dialog.setHeaderText("Connection to a server");
        dialog.setContentText("Enter host name:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(address -> {
            serverAdress = address;
            performer.connect(address);
        });
    }

    void showErrorAlert(String header, String content) {
        SoapProtocolPerformer.showErrorAlert(header, content);
    }
}
