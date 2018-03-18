import org.apache.axis2.AxisFault;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.ws.axis2.J2EeHandbookServiceStub;

import java.rmi.RemoteException;

public class SoapProtocolPerformer implements ProtocolPerformer {
    private final static String END_POINT = "http://localhost:8080/axis2/services/J2EeHandbookService?wsdl";

    private static final Logger log = LogManager.getLogger(SoapProtocolPerformer.class);

    public void doSomething() {
        J2EeHandbookServiceStub.Worker worker = new J2EeHandbookServiceStub.Worker();
        worker.setName("Mark");
        worker.setSurname("Lahvinovich");
        worker.setPosition("Lead Engineer");
        worker.setSalary(20000);

        J2EeHandbookServiceStub stub = null;
        try {
            stub = new J2EeHandbookServiceStub(END_POINT);
        } catch (AxisFault axisFault) {
            log.fatal(axisFault.getMessage());
            System.exit(1);
        }
        J2EeHandbookServiceStub.GetWorkerWithChangedSalary workerOperation = new J2EeHandbookServiceStub.GetWorkerWithChangedSalary();
        workerOperation.setWorker(worker);

        J2EeHandbookServiceStub.GetWorkerWithChangedSalaryResponse response = null;
        try {
            response = stub.getWorkerWithChangedSalary(workerOperation);
        } catch (RemoteException exception) {
            log.fatal(exception.getMessage());
            System.exit(1);
        }

        J2EeHandbookServiceStub.Worker returnedWorker = response.get_return();

        System.out.println("Name: " + returnedWorker.getName());
        System.out.println("Surname: " + returnedWorker.getSurname());
        System.out.println("Position: " + returnedWorker.getPosition());
        System.out.println("Salary: " + returnedWorker.getSalary());
    }
}
