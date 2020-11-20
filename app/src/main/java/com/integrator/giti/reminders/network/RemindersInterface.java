package com.integrator.giti.reminders.network;

import com.integrator.giti.reminders.model.response.MedicamentoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemindersInterface {

    @GET("getMedicamentos")
    Call<List<MedicamentoResponse>> getListMedicamentos(@Query("pacienteId") Integer pacienteId);



}
