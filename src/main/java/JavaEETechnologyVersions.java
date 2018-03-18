import javafx.beans.property.SimpleStringProperty;

public class JavaEETechnologyVersions {
    private SimpleStringProperty rVForJava4;
    private SimpleStringProperty rVForJava5;
    private SimpleStringProperty rVForJava6;
    private SimpleStringProperty rVForJava7;
    private SimpleStringProperty rVForJava8;

    JavaEETechnologyVersions(String rVForJava4, String rVForJava5, String rVForJava6, String rVForJava7, String rVForJava8) {
        this.rVForJava4 = new SimpleStringProperty(rVForJava4);
        this.rVForJava5 = new SimpleStringProperty(rVForJava5);
        this.rVForJava6 = new SimpleStringProperty(rVForJava6);
        this.rVForJava7 = new SimpleStringProperty(rVForJava7);
        this.rVForJava8 = new SimpleStringProperty(rVForJava8);
    }

    public String getRVForJava4() {
        return rVForJava4.get();
    }

    public void setRVForJava4(String rVForJava4) {
        this.rVForJava4.set(rVForJava4);
    }

    public String getRVForJava5() {
        return rVForJava5.get();
    }

    public void setRVForJava5(String rVForJava5) {
        this.rVForJava5.set(rVForJava5);
    }

    public String getRVForJava6() {
        return rVForJava6.get();
    }

    public void setRVForJava6(String rVForJava6) {
        this.rVForJava6.set(rVForJava6);
    }

    public String getRVForJava7() {
        return rVForJava7.get();
    }

    public void setRVForJava7(String rVForJava7) {
        this.rVForJava7.set(rVForJava7);
    }

    public String getRVForJava8() {
        return rVForJava8.get();
    }

    public void setRVForJava8(String rVForJava8) {
        this.rVForJava8.set(rVForJava8);
    }

    public void set(JavaEETechnologyVersions versions) {
        this.rVForJava4.set(versions.getRVForJava4());
        this.rVForJava5.set(versions.getRVForJava5());
        this.rVForJava6.set(versions.getRVForJava6());
        this.rVForJava7.set(versions.getRVForJava7());
        this.rVForJava8.set(versions.getRVForJava8());
    }
}
