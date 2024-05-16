package shivam.javacode.collection;

public class Person {

    private int eId;
    private String eName;
    private String ePosition;


    public Person(int eId, String eName, String ePosition)
{
    this.eId=eId;
    this.eName=eName;
    this.ePosition=ePosition;
}

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getePosition() {
        return ePosition;
    }

    public void setePosition(String ePosition) {
        this.ePosition = ePosition;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "collection{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", ePosition='" + ePosition + '\'' +
                '}';
    }
}
