package com.example.desafiomarvel.repository;

import com.example.desafiomarvel.model.ComicsResponse;

import io.reactivex.Observable;

import static com.example.desafiomarvel.data.remote.RetrofitService.getApiService;

public class ComicsRepository {

    public Observable<ComicsResponse> getComics(String data, String format, String formatType, String order, String timestamp, String hash, String apiKey, int offset) {
        return getApiService().getAllComics(data, format, formatType, order, timestamp, hash, apiKey, offset);
    }
}
