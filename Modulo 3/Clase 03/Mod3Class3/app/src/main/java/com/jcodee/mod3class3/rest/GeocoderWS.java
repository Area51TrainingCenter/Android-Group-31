package com.jcodee.mod3class3.rest;

import com.jcodee.mod3class3.rest.response.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by johannfjs on 29/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface GeocoderWS {
    @GET("geocode/json?address={address}")
    Call<ResultResponse> obtenerPosicion(@Path("address") String address);
}
