import org.apache.ws.axis2.J2EeHandbookServiceStub.JavaEETechnology;

interface ProtocolPerformer {
    JavaEETechnology[] getAllTechnologies();
    void insert(JavaEETechnology technology);
    void delete(JavaEETechnology technology);
    void update(JavaEETechnology technology);
}
