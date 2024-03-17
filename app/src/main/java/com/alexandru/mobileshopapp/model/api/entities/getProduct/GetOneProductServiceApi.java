package com.alexandru.mobileshopapp.model.api.entities.getProduct;

import com.alexandru.mobileshopapp.model.api.entities.getProducts.ProductSmall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetOneProductServiceApi {
        @GET("/products/{id}")
        Call<GetOneProductResponse> getProductById(@Path("id") int id);
}

