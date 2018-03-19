import javafx.scene.control.Alert;
import org.apache.axis2.AxisFault;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.ws.axis2.J2EeHandbookServiceStub;
import org.apache.ws.axis2.J2EeHandbookServiceStub.GetAllTechnologies;
import org.apache.ws.axis2.J2EeHandbookServiceStub.AddTechnology;
import org.apache.ws.axis2.J2EeHandbookServiceStub.RemoveTechnology;
import org.apache.ws.axis2.J2EeHandbookServiceStub.UpdateTechnology;
import org.apache.ws.axis2.J2EeHandbookServiceStub.GetAllTechnologiesResponse;
import org.apache.ws.axis2.J2EeHandbookServiceStub.JavaEETechnology;


public class SoapProtocolPerformer implements ProtocolPerformer {
    private static final Logger log = LogManager.getLogger(SoapProtocolPerformer.class);
    private J2EeHandbookServiceStub serviceStub = null;

    public void connect(String address) {
        try {
            serviceStub = new J2EeHandbookServiceStub(address);
        } catch (AxisFault axisFault) {
            log.error(axisFault.getMessage());
            showErrorAlert("Server error", axisFault.getMessage());
        }
    }

    public JavaEETechnology[] getAllTechnologies() {
        GetAllTechnologies operation = new GetAllTechnologies();
        GetAllTechnologiesResponse response;
        JavaEETechnology[] returnedTechnologies = new JavaEETechnology[0];

        try {
            response = serviceStub.getAllTechnologies(operation);
            returnedTechnologies = response.get_return();
        } catch (Exception e) {
            log.error(e.getMessage());
            showErrorAlert("Server error", e.getMessage());
        }
        return returnedTechnologies;
    }

    @Override
    public void insert(JavaEETechnology technology) {
        AddTechnology operation = new AddTechnology();
        operation.setTechnology(technology);

        try {
            serviceStub.addTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
            showErrorAlert("Server error", e.getMessage());
        }
    }

    @Override
    public void delete(JavaEETechnology technology) {
        RemoveTechnology operation = new RemoveTechnology();
        operation.setTechnology(technology);

        try {
            serviceStub.removeTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
            showErrorAlert("Server error", e.getMessage());
        }
    }

    @Override
    public void update(JavaEETechnology technology) {
        UpdateTechnology operation = new UpdateTechnology();
        operation.setTechnology(technology);

        try {
            serviceStub.updateTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
            showErrorAlert("Server error", e.getMessage());
        }
    }

    static void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
