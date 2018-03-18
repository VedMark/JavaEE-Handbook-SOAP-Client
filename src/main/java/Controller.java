import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    ProtocolPerformer performer;

    @FXML
    TableView<JavaEETechnology> javaTechnologiesTable;
    @FXML
    TableColumn<JavaEETechnology, String> iName;
    @FXML
    TableColumn<JavaEETechnologyVersions, String> iVForJava4;
    @FXML
    TableColumn<JavaEETechnologyVersions, String> iVForJava5;
    @FXML
    TableColumn<JavaEETechnologyVersions, String> iVForJava6;
    @FXML
    TableColumn<JavaEETechnologyVersions, String> iVForJava7;
    @FXML
    TableColumn<JavaEETechnologyVersions, String> iVForJava8;
    @FXML
    TableColumn<JavaEETechnology, String> iDescription;

    private final ObservableList<JavaEETechnology> data = FXCollections.observableArrayList(
            new JavaEETechnology("JSP", new JavaEETechnologyVersions("1","2","3","4","5"), "some f*ing s*t"),
            new JavaEETechnology("Servlets", new JavaEETechnologyVersions("5","2","3","4","1"), "another f*ing s*t")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iName.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("rName"));
        iVForJava4.setCellValueFactory(new PropertyValueFactory<JavaEETechnologyVersions, String>("rVForJava4"));
        iVForJava5.setCellValueFactory(new PropertyValueFactory<JavaEETechnologyVersions, String>("rVForJava5"));
        iVForJava6.setCellValueFactory(new PropertyValueFactory<JavaEETechnologyVersions, String>("rVForJava6"));
        iVForJava7.setCellValueFactory(new PropertyValueFactory<JavaEETechnologyVersions, String>("rVForJava7"));
        iVForJava8.setCellValueFactory(new PropertyValueFactory<JavaEETechnologyVersions, String>("rVForJava8"));
        iDescription.setCellValueFactory(new PropertyValueFactory<JavaEETechnology, String>("rDescription"));

        javaTechnologiesTable.setItems(data);
    }

    @FXML
    private void handleRpcAction(ActionEvent event) {

    }

    @FXML
    private void handleSoapAction(ActionEvent event) {

    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        System.out.println("Add action");
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {

    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {

    }

    @FXML
    private void handleConnectAction(ActionEvent event) {

    }
}
