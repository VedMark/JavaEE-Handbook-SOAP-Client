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
    private final static String END_POINT = "http://localhost:8080/axis2/services/J2EeHandbookService?wsdl";
    private static final Logger log = LogManager.getLogger(SoapProtocolPerformer.class);

    public JavaEETechnology[] getAllTechnologies() {
        J2EeHandbookServiceStub stub;
        GetAllTechnologies operation = new GetAllTechnologies();
        GetAllTechnologiesResponse response;
        JavaEETechnology[] returnedTechnologies = new JavaEETechnology[0];

        try {
            stub = new J2EeHandbookServiceStub(END_POINT);
            response = stub.getAllTechnologies(operation);
            returnedTechnologies = response.get_return();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return returnedTechnologies;
    }

    @Override
    public void insert(JavaEETechnology technology) {
        J2EeHandbookServiceStub stub;
        AddTechnology operation = new AddTechnology();
        operation.setTechnology(technology);

        try {
            stub = new J2EeHandbookServiceStub(END_POINT);
            stub.addTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(JavaEETechnology technology) {
        J2EeHandbookServiceStub stub;
        RemoveTechnology operation = new RemoveTechnology();
        operation.setTechnology(technology);

        try {
            stub = new J2EeHandbookServiceStub(END_POINT);
            stub.removeTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(JavaEETechnology technology) {
        J2EeHandbookServiceStub stub;
        UpdateTechnology operation = new UpdateTechnology();
        operation.setTechnology(technology);

        try {
            stub = new J2EeHandbookServiceStub(END_POINT);
            stub.updateTechnology(operation);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
