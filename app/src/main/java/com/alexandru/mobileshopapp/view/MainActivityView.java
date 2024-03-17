package com.alexandru.mobileshopapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alexandru.mobileshopapp.R;
import com.alexandru.mobileshopapp.model.api.ProductApiClient;
import com.alexandru.mobileshopapp.model.api.entities.getProducts.ProductSmall;
import com.alexandru.mobileshopapp.view.recycleView.ButtonClickListener;
import com.alexandru.mobileshopapp.view.recycleView.ProductListAdaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivityView extends AppCompatActivity implements ButtonClickListener {

    private RecyclerView recyclerView;
    public  List<ProductSmall> productList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    int currentPage = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        recyclerView = findViewById(R.id.recycle_view_list_products);

        linearLayoutManager = new LinearLayoutManager(this);

        populateProductListFromAPI(currentPage);
    }

    public void onLoadMoreClickMain() {
        currentPage++;
        populateProductListFromAPI(currentPage);
    }

    public void populateProductListFromAPI(int page){
        ProductApiClient productApiClient = new ProductApiClient();
        productApiClient.getProducts(null, null, null, page, 10, new ProductApiClient.ProductSmallCallback() {
            @Override
            public void onProductsReceived(List<ProductSmall> products) {
                productList.addAll(products);
                UpdateUIWIthProds();
            }

            @Override
            public void onProductsError(String message) {
                Toast.makeText(getActivity(),
                        message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public MainActivityView getActivity(){
        return MainActivityView.this;
    }


    private void UpdateUIWIthProds(){
        if(productList.isEmpty()){

        } else {
            ProductListAdaptor productListAdaptor =  new ProductListAdaptor(productList, getApplicationContext(), this);
            recyclerView.setLayoutManager(linearLayoutManager);
            int scroolPos = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).findFirstCompletelyVisibleItemPosition();
            recyclerView.scrollToPosition(scroolPos);
            recyclerView.setAdapter(productListAdaptor);

        }
    }

    @Override
    public void onButtonClick() {
        onLoadMoreClickMain();
    }
}