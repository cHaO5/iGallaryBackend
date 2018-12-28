package j2ee.demo.utils;

import j2ee.demo.configuration.ResultStatus;

public class ErrorResult extends ResultModel {
    private String error;

    public ErrorResult(ResultStatus status) {
        this.error = status.getMessage();
    }

    public ErrorResult(String msg) {
        this.error = msg;
    }

    public void setError(ResultStatus status) {
        this.error = status.getMessage();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
