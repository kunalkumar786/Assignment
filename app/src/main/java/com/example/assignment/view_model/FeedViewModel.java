package com.example.assignment.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.assignment.network.NetworkClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedViewModel extends AndroidViewModel {
MutableLiveData<String> feed_data;

    public FeedViewModel(@NonNull Application application) {
        super(application);
    }
public MutableLiveData<String> getFeedData(){
        if(feed_data==null){
            feed_data=new MutableLiveData<>();
            callFeedApi();
        }
return feed_data;
    }
public void callFeedApi(){
    NetworkClient.APIClient apiClient = NetworkClient.getNetworkClientInstance().getApiClient();
    apiClient.sendRequest().enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                if (response.code() == 200) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        feed_data.setValue(jsonObject.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });
}




}
