package com.example.assignment.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.assignment.model.FeedModel;
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
MutableLiveData<ArrayList<FeedModel>> feed_list;
    public FeedViewModel(@NonNull Application application) {
        super(application);
    }
public MutableLiveData<String> getFeedData(String news_id){
        if(feed_data==null){
            feed_data=new MutableLiveData<>();
            callNewsDetails(news_id);
        }
return feed_data;
    }
  public MutableLiveData<ArrayList<FeedModel>> getFeed_list(){
        if(feed_list==null){
            feed_list=new MutableLiveData<>();
            callFeedApi();
        }
  return feed_list;
    }

public void callNewsDetails(String endpoint){
    NetworkClient.APIClient apiClient = NetworkClient.getNetworkClientInstance().getApiClient();
    apiClient.sendRequest(endpoint).enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try{
                if(response.code()==200){
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    feed_data.setValue(jsonObject.toString());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });
}


public void callFeedApi(){
    NetworkClient.APIClient apiClient = NetworkClient.getNetworkClientInstance().getApiClient();
    apiClient.TopStories().enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                if (response.code() == 200) {
                    try {
                        JSONArray jsonArray=new JSONArray(response.body().string());
                        //JSONObject jsonObject = new JSONObject(response.body().string());

                  ArrayList<FeedModel> feedModels=new ArrayList<>();
                   for(int i=0;i<jsonArray.length();i++){
                  FeedModel feedModel=new FeedModel();
                  feedModel.setTitle(jsonArray.get(i).toString());
                  feedModels.add(feedModel);

                   }
                        feed_list.setValue(feedModels);
                       // feed_data.setValue(jsonArray.toString());
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
