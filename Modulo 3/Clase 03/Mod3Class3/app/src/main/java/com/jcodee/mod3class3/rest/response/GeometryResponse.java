package com.jcodee.mod3class3.rest.response;

/**
 * Created by johannfjs on 29/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GeometryResponse {
    private LocationResponse location;
    private String location_type;
    private ViewportResponse viewport;

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public ViewportResponse getViewport() {
        return viewport;
    }

    public void setViewport(ViewportResponse viewport) {
        this.viewport = viewport;
    }
}
