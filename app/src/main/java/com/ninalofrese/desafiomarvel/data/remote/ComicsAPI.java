package com.ninalofrese.desafiomarvel.data.remote;

import com.ninalofrese.desafiomarvel.model.ComicsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ComicsAPI {

    @GET("comics")
    Observable<ComicsResponse> getAllComics(@Query("dateDescriptor") String data,
                                            @Query("format") String format,
                                            @Query("formatType") String formatType,
                                            @Query("orderBy") String order,
                                            @Query("ts") String timestamp,
                                            @Query("hash") String hash,
                                            @Query("apikey") String apiKey,
                                            @Query("noVariants") Boolean noVariants,
                                            @Query("offset") int offset);

    @GET("comics/{comicId}")
    Observable<ComicsResponse> getSingleComic(@Path("comicId") Long id,
                                              @Query("ts") String timestamp,
                                              @Query("hash") String hash,
                                              @Query("apikey") String apiKey);

}
