package com.jcodee.mod3class1_1.rest;

import com.jcodee.mod3class1_1.rest.response.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by johannfjs on 24/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface TypicodeWS {
    /*
    * GET -> Obtener datos
    * POST -> Enviar datos
    * PUT -> Actualizar datos
    * DELETE -> Eliminar datos
    * PATCH -> Actualizar datos
    */

    @GET("users")
    Call<ArrayList<UserResponse>> obtenerUsuarios();
}
