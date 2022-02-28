package com.hasan.crowdcarnival.rest;

import com.hasan.crowdcarnival.models.response.SMSResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SMSServiceEndPoint {

    @GET("api/v3/sendsms/plain?")
    Call<SMSResponse> sendSMStoUser(
            @Query("username") String username,
            @Query("password") String password,
            @Query("sender") String sender,
            @Query("text") String text,
            @Query("to") String to
    );
}
