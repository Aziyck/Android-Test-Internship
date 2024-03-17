package com.alexandru.mobileshopapp.model.api.entities.getProducts;

import com.alexandru.mobileshopapp.model.api.entities.getProducts.ProductSmall;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProductsSmallApiResponse {
    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<ProductSmall> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductSmall> getResults() {
        return results;
    }

    public void setResults(List<ProductSmall> results) {
        this.results = results;
    }
}