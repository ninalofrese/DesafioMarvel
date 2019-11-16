package com.ninalofrese.desafiomarvel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ninalofrese.desafiomarvel.model.Result;
import com.ninalofrese.desafiomarvel.repository.ComicsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.ninalofrese.desafiomarvel.util.DataMarvelUtils.PRIVATE_KEY;
import static com.ninalofrese.desafiomarvel.util.DataMarvelUtils.PUBLIC_KEY;
import static com.ninalofrese.desafiomarvel.util.Md5CreatorUtils.md5;

public class HomeActivityViewModel extends AndroidViewModel {
    private String timestamp = Long.toString(System.currentTimeMillis() / 1000);
    private String hash = md5(timestamp + PRIVATE_KEY + PUBLIC_KEY);
    private String order = "onsaleDate";
    private String date = "thisMonth";
    private String format = "comic";
    private String formatType = "comic";

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

    public void getThisMonthComics(int offset) {
        disposable.add(
                repository.getComics(date, format, formatType, order, timestamp, hash, PUBLIC_KEY, true, offset)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> {
                            loading.setValue(true);
                        })
                        .doAfterTerminate(() -> {
                            loading.setValue(false);
                        })
                        .subscribe(comicsResponse -> {
                            comicList.setValue(comicsResponse.getData().getResults());
                        }, throwable -> {
                            error.setValue(throwable.getMessage());
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
