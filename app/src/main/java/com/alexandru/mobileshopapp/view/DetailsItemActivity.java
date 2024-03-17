package com.alexandru.mobileshopapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alexandru.mobileshopapp.R;
import com.alexandru.mobileshopapp.model.api.ProductApiClient;
import com.alexandru.mobileshopapp.model.api.entities.getProduct.ProductBig;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailsItemActivity extends AppCompatActivity {
    private int id;
    ImageView imageView;
    TextView productName;
    TextView size;
    TextView productPrice;
    TextView productPriceSecondary;
    TextView description;
    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_item);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        try {
            id = getIntent().getIntExtra("id",1);
        } catch (Exception ignore){

        }

        imageView = findViewById(R.id.image_view);
        productName = findViewById(R.id.prod_name);
        size = findViewById(R.id.size);
        productPrice = findViewById(R.id.price_prod);
        productPriceSecondary = findViewById(R.id.price_prod_secondary);
        description = findViewById(R.id.prod_desc);
        backBtn = findViewById(R.id.back_btn_icon);

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityView.class);
            startActivity(intent);
        });

        getProductFromApi();
    }

    private void bindProduct(ProductBig product){
        Picasso.get().load(product.getMainImage()).into(imageView);
        productName.setText(product.getName());
        size.setText(product.getSize() + "\n" + product.getColour());
        String priceString = String.format(Locale.UK,"$%.1f-", product.getPrice());
        productPrice.setText(priceString);
        productPriceSecondary.setText(priceString);
        description.setText(product.getDetails());

    }
    public void getProductFromApi(){
        ProductApiClient productApiClient = new ProductApiClient();
        productApiClient.getOneProduct(id, new ProductApiClient.ProductBigCallback(){

            @Override
            public void onProductsReceived(ProductBig product) {
                bindProduct(product);
            }

            @Override
            public void onProductsError(String message) {
                Toast.makeText(getActivity(),
                        message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public DetailsItemActivity getActivity(){
        return DetailsItemActivity.this;
    }


}
