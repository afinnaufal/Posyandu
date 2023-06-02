package com.example.aplikasiapoti;

import java.util.List;

public class BayiResponse {

    private List<BayiData> data;
    private String status;

    public List<BayiData> getData() {
        return data;
    }

    public void setData(List<BayiData> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
