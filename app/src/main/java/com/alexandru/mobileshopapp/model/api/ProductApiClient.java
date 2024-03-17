package com.alexandru.mobileshopapp.model.api;

import androidx.annotation.NonNull;

import com.alexandru.mobileshopapp.model.api.entities.getProduct.GetOneProductResponse;
import com.alexandru.mobileshopapp.model.api.entities.getProduct.GetOneProductServiceApi;
import com.alexandru.mobileshopapp.model.api.entities.getProduct.ProductBig;
import com.alexandru.mobileshopapp.model.api.entities.getProducts.GetProductsSmallServiceApi;
import com.alexandru.mobileshopapp.model.api.entities.getProducts.GetProductsSmallApiResponse;
import com.alexandru.mobileshopapp.model.api.entities.getProducts.ProductSmall;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductApiClient {

    private final GetProductsSmallServiceApi getProductsSmallServiceApi;
    private final GetOneProductServiceApi getOneProductServiceApi;


    public ProductApiClient() {
        getProductsSmallServiceApi = RetrofitClient.getClient().create(GetProductsSmallServiceApi.class);
        getOneProductServiceApi = RetrofitClient.getClient().create(GetOneProductServiceApi.class);
    }

    public void getProducts(String ordering, String search, String categoryId, int page, int pageSize, final ProductSmallCallback callback) {
        Call<GetProductsSmallApiResponse> call = getProductsSmallServiceApi.getProducts(ordering, search, categoryId, page, pageSize);

        call.enqueue(new Callback<GetProductsSmallApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetProductsSmallApiResponse> call, @NonNull Response<GetProductsSmallApiResponse> response) {
                if (response.isSuccessful()) {
                    GetProductsSmallApiResponse apiResponse = response.body();
                    if (apiResponse != null) {
                        callback.onProductsReceived(apiResponse.getResults());
                    } else {
                        callback.onProductsError("Response body is null");
                    }
                } else {
                    callback.onProductsError("Failed to get products: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetProductsSmallApiResponse> call, @NonNull Throwable t) {
                callback.onProductsError("Failed to get products: " + t.getMessage());
            }
        });
    }

    public void getOneProduct(int id, final ProductBigCallback callback){
        Call<GetOneProductResponse> call = getOneProductServiceApi.getProductById(id);

        call.enqueue(new Callback<GetOneProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetOneProductResponse> call, @NonNull Response<GetOneProductResponse> response) {
                if(response.isSuccessful()){
                    GetOneProductResponse apiResponse = response.body();
                    if(apiResponse != null){
                        callback.onProductsReceived(apiResponse);
                    } else {
                        callback.onProductsError("Response body is null");
                    }
                } else {
                    callback.onProductsError("Failed to get products: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetOneProductResponse> call, @NonNull Throwable t) {
                callback.onProductsError("Failed to get products: " + t.getMessage());
            }
        });
    }



    public interface ProductSmallCallback {
        void onProductsReceived(List<ProductSmall> products);
        void onProductsError(String message);
    }

    public interface ProductBigCallback{
        void onProductsReceived(ProductBig product);

        void onProductsError(String message);
    }


}