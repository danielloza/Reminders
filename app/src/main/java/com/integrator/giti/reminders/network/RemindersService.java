package com.integrator.giti.reminders.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemindersService {

    private static final String BASE_URL = "https://rest-api-endpoint.herokuapp.com/recordatorios/";
    private static Retrofit retrofit;
    private RemindersInterface remindersInterface;
    private static RemindersService instance = null;


    public RemindersService() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(3, TimeUnit.MINUTES);
        ///okHttpClientBuilder.addInterceptor(new AuthInterceptor());
        OkHttpClient client = okHttpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        remindersInterface = retrofit.create(RemindersInterface.class);
    }

    /**
     * Singleton Method
     * @return
     */
    public static RemindersService getInstance() {
        if (instance == null) {
            instance = new RemindersService();
        }

        return instance;
    }

    /**
     *
     */
    public RemindersInterface getAuthApiService() {
        return remindersInterface;
    }
}
