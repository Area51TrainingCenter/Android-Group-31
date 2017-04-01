package com.jcodee.mod3class4_1.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.jcodee.mod3class4_1.GPNCalculatorSoap;

/**
 * Created by johannfjs on 31/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SumarAsyntask extends AsyncTask<String, Void, String> {
    Context context;
    ProgressDialog progressDialog;
    int value1, value2;

    public SumarAsyntask(Context context, int value1, int value2) {
        this.context = context;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Cargando ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected String doInBackground(String... params) {
        GPNCalculatorSoap soap = new GPNCalculatorSoap();
        int result = 0;
        try {
            result = soap.Add(value1, value2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(result);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        progressDialog.dismiss();
    }
}
