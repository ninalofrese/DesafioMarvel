package com.example.desafiomarvel.repository;

import com.example.desafiomarvel.model.Data;

import io.reactivex.Single;

import static com.example.desafiomarvel.data.remote.RetrofitService.getApiService;

public class ComicsRepository {

    public Single<Data> getComics(String data, String format, String formatType, String order, String timestamp, String hash, String apiKey, int count) {
        return getApiService().getAllComics(data, format, formatType, order, timestamp, hash, apiKey, count);
    }
}
