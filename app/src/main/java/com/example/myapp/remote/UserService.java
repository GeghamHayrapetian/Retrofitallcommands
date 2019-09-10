package com.example.myapp.remote;


import com.example.myapp.Constants;
import com.example.myapp.model.Comment;
import com.example.myapp.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserService {
    @GET(Constants.END_POINT_1)
    Call<List<Post>> getPosts();

    @GET(Constants.END_POINT_2)
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET(Constants.END_POINT_1)
    Call<List<Post>> getPostsById(@Query("userId") int userId);

    @GET(Constants.END_POINT_1)
    Call<List<Post>> getPostsUsingMap(@QueryMap Map<String, String> parameters);
}
