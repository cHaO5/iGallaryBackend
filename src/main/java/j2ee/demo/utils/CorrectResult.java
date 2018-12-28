package j2ee.demo.utils;

public class CorrectResult extends ResultModel {
    private Object receive;

    public CorrectResult(Object receive) {
        this.receive = receive;
    }

    public Object getReceive() {
        return receive;
    }

    public void setReceive(Object receive) {
        this.receive = receive;
    }
}
