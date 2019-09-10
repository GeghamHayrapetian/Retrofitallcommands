package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.model.Comment;
import com.example.myapp.model.Post;
import com.example.myapp.remote.ApiUtils;
import com.example.myapp.remote.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text);

         // getPosts();
          //getPostsById(4);
        getPostsUsingMap();
        //getComments();
//        createPost();

    }

    private void getPosts() {
        userService = ApiUtils.getUserService();
        userService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    List<Post> posts = response.body();
                    for (Post post : posts) {
                        String content = "";
                        content += "Id: " + post.getId() + "\n";
                        content += "UserId: " + post.getUserId() + "\n";
                        content += "Title : " + post.getTitle() + "\n";
                        content += "Body: " + post.getBody() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPostsById(int id) {
        userService = ApiUtils.getUserService();
        Call<List<Post>> post = userService.getPostsById(id);

        post.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    List<Post> posts = response.body();
                    System.out.println("size " + posts.size());
                    for (Post post : posts) {
                        String content = "";
                        content += "Id: " + post.getId() + "\n";
                        content += "UserId: " + post.getUserId() + "\n";
                        content += "Title : " + post.getTitle() + "\n";
                        content += "Body: " + post.getBody() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getComments() {
        userService = ApiUtils.getUserService();
        Call<List<Comment>> call = userService.getComments(3);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

                    List<Comment> comments = response.body();
                    for (Comment comment : comments) {
                        String content = "";
                        content += "ID: " + comment.getId() + "\n";
                        content += "Post ID: " + comment.getPostId() + "\n";
                        content += "Name: " + comment.getName() + "\n";
                        content += "Email: " + comment.getEmail() + "\n";
                        content += "Body: " + comment.getBody() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPostsUsingMap() {
        userService = ApiUtils.getUserService();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        Call<List<Post>> post = userService.getPostsUsingMap(parameters);
        post.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    List<Post> posts = response.body();
                    System.out.println("size " + posts.size());
                    for (Post post : posts) {
                        String content = "";
                        content += "Id: " + post.getId() + "\n";
                        content += "UserId: " + post.getUserId() + "\n";
                        content += "Title : " + post.getTitle() + "\n";
                        content += "Body: " + post.getBody() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });


    }


}