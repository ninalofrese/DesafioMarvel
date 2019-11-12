package com.example.desafiomarvel.data.remote;

import com.example.desafiomarvel.model.Data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ComicsAPI {

    @GET("comics")
    Single<Data> getAllComics(@Query("dateDescriptor") String data,
                              @Query("format") String format,
                              @Query("formatType") String formatType,
                              @Query("orderBy") String order,
                              @Query("ts") String timestamp,
                              @Query("hash") String hash,
                              @Query("apikey") String apiKey,
                              @Query("count") int count);
}
