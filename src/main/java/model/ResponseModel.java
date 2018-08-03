package model;

public class ResponseModel {
    private int status;
    private String response;

    public ResponseModel(int responseCode, String response) {
        this.response = response;
        this.status = responseCode;
    }
}
