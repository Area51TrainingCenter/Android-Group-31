package com.jcodee.mod3class1_1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 24/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class UserResponse {
    private int id;
    @SerializedName("name")
    private String nombre;
    private String username;
    private String email;
    private String phone;
    @SerializedName("website")
    private String paginaWeb;
    private AddressResponse address;
    private CompanyResponse company;

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public CompanyResponse getCompany() {
        return company;
    }

    public void setCompany(CompanyResponse company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
