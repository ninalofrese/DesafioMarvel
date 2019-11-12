package com.example.desafiomarvel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.desafiomarvel.model.Result;
import com.example.desafiomarvel.repository.ComicsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.desafiomarvel.util.Md5CreatorUtils.md5;

public class HomeActivityViewModel extends AndroidViewModel {
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";
    public String timestamp = Long.toString(System.currentTimeMillis() / 1000);
    public String hash = md5(timestamp + PRIVATE_KEY + PUBLIC_KEY);
    public String order = "onsaleDate";
    public String data = "thisMonth";
    public String format = "comic";
    public String formatType = "comic";
    public int count = 20;

    private MutableLiveData<List<Result>> comicList = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private ComicsRepository repository = new ComicsRepository();

    public HomeActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getComics() {
        return this.comicList;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public LiveData<String> getError() {
        return this.error;
    }

    public void getThisMonthComics(String dateDescriptor, String format, String formatType, String order, String timestamp, String hash, String apikey, int count) {
        disposable.add(
                repository.getComics(dateDescriptor, format, formatType, order, timestamp, hash, apikey, count)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> {
                            loading.setValue(true);
                        })
                        .doAfterTerminate(() -> {
                            loading.setValue(false);
                        })
                        .subscribe(data1 -> {
                            comicList.setValue(data1.getResults());
                        }, throwable -> {
                            error.setValue(throwable.getMessage());
                        })
        );
    }
}
