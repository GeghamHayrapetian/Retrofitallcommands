package com.example.myapp.remote;

import com.example.myapp.Constants;

public class ApiUtils {
    public static UserService getUserService() {
        return RetrofitClient.getRetrofitClient(Constants.BASE_URL).
                create(UserService.class);
    }
}