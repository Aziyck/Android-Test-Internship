package com.alexandru.mobileshopapp.model.api.entities.getProducts;

import com.alexandru.mobileshopapp.model.api.entities.getProducts.GetProductsSmallApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetProductsSmallServiceApi {
    @GET("/products")
    Call<GetProductsSmallApiResponse> getProducts(
            @Query("ordering") String ordering,
            @Query("search") String search,
            @Query("category_id") String categoryId,
            @Query("page") int page,
            @Query("page_size") int pageSize
    );
}