import javafx.beans.property.SimpleStringProperty;

public class JavaEETechnology {
    private final SimpleStringProperty rName;
    private final JavaEETechnologyVersions rVersions;
    private final SimpleStringProperty rDescription;

    JavaEETechnology(String rName, JavaEETechnologyVersions rVersions, String rDescription) {
        this.rName = new SimpleStringProperty(rName);
        this.rVersions = rVersions;
        this.rDescription = new SimpleStringProperty(rDescription);
    }

    public String getRName() {
        return rName.get();
    }

    public void setRName(String rName) {
        this.rName.set(rName);
    }

    public String getRVForJava4() {
        return rVersions.getRVForJava4();
    }

    public void setRVersionsForJava4(String v4) {
        this.rVersions.setRVForJava4(v4);
    }

    public String getRVForJava5() {
        return rVersions.getRVForJava5();
    }

    public void setRVersionsForJava5(String v5) {
        this.rVersions.setRVForJava5(v5);
    }

    public String getRVForJava6() {
        return rVersions.getRVForJava6();
    }

    public void setRVersionsForJava6(String v6) {
        this.rVersions.setRVForJava6(v6);
    }

    public String getRVForJava7() {
        return rVersions.getRVForJava7();
    }

    public void setRVersionsForJava7(String v7) {
        this.rVersions.setRVForJava7(v7);
    }

    public String getRVForJava8() {
        return rVersions.getRVForJava8();
    }

    public void setRVersionsForJava8(String v8) {
        this.rVersions.setRVForJava8(v8);
    }

    public String getRDescription() {
        return rDescription.get();
    }

    public void setRDescription(String rDescription) {
        this.rDescription.set(rDescription);
    }
}
