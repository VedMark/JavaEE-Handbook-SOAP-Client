import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.apache.ws.axis2.J2EeHandbookServiceStub.JavaEETechnology;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
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
        iVForJava4.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava4"));
        iVForJava4.setCellFactory(cellFactory);
        iVForJava5.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava5"));
        iVForJava5.setCellFactory(cellFactory);
        iVForJava6.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava6"));
        iVForJava6.setCellFactory(cellFactory);
        iVForJava7.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava7"));
        iVForJava7.setCellFactory(cellFactory);
        iVForJava8.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("versionForJava8"));
        iVForJava8.setCellFactory(cellFactory);
        iDescription.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("description"));
        iDescription.setCellFactory(cellFactory);

        javaTechnologiesTable.setItems(data);

        getAllData();
    }

    void getAllData() {
        JavaEETechnology[] technologies = performer.getAllTechnologies();
        if(technologies != null) {
            data.addAll(technologies);
        }
    }

    void addCurrentRow() {
        performer.insert(javaTechnologiesTable.getSelectionModel().getSelectedItem());
    }

    void removeCurrentRow() {
        performer.delete(javaTechnologiesTable.getSelectionModel().getSelectedItem());
    }

    void updateCurrentRow() {
        System.out.println("update");
        performer.update(javaTechnologiesTable.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleSynchronizeAction() {
        getAllData();
    }

    @FXML
    private void handleRpcAction(ActionEvent event) {

    }

    @FXML
    private void handleSoapAction(ActionEvent event) {

    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        System.out.println("update");
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {

    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
        System.out.println("update");
    }

    @FXML
    private void handleConnectAction(ActionEvent event) {

    }
}
