package com.jcodee.mod3class3.rest.response;

import java.util.ArrayList;

/**
 * Created by johannfjs on 29/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ResultDetalleResponse {
    private ArrayList<AddressComponentResponse> address_components;
    private String formatted_address;
    private String place_id;
    private String[] types;
    private GeometryResponse geometry;

    public ArrayList<AddressComponentResponse> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(ArrayList<AddressComponentResponse> address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public GeometryResponse getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryResponse geometry) {
        this.geometry = geometry;
    }
}
