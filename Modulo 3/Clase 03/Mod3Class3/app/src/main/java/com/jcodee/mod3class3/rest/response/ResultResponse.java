package com.jcodee.mod3class3.rest.response;

import java.util.ArrayList;

/**
 * Created by johannfjs on 29/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ResultResponse {
    private String status;
    private ArrayList<ResultDetalleResponse> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ResultDetalleResponse> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultDetalleResponse> results) {
        this.results = results;
    }
}
