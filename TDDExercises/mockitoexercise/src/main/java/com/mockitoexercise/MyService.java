package com.mockitoexercise;

public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchDataById(int id) {
        return api.getDataById(id);
    }

    public void sendData(String data) {
        api.sendData(data);
    }

    public void processData(String data) {
        api.processData(data);
    }
}
