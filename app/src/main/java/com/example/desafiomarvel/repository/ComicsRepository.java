package com.example.desafiomarvel.repository;

import com.example.desafiomarvel.model.ComicsResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

import static com.example.desafiomarvel.data.remote.RetrofitService.getApiService;

public class ComicsRepository {

    public Observable<ComicsResponse> getComics(String data, String format, String formatType, String order, String timestamp, String hash, String apiKey, Boolean noVariants, int offset) {
        return getApiService().getAllComics(data, format, formatType, order, timestamp, hash, apiKey, noVariants, offset);
    }

    public Observable<ComicsResponse> getSingle(Long id, String timestamp, String hash, String apiKey) {
        return getApiService().getSingleComic(id, timestamp, hash, apiKey);
    }

}
