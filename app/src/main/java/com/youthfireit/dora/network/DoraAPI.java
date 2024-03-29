package com.youthfireit.dora.network;

import com.youthfireit.dora.models.BannerData;
import com.youthfireit.dora.models.Categories;
import com.youthfireit.dora.models.login.Login;
import com.youthfireit.dora.models.SignUp;
import com.youthfireit.dora.models.productdetails.ProductDetails;
import com.youthfireit.dora.models.allproducts.Products;
import com.youthfireit.dora.models.productdetails.RelatedProducts;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface DoraAPI {

    @GET("products")
    Call<Products> getAllProductData(@Query("page") int page);


    @GET("products/{id}")
    Call<ProductDetails> getSingleProducts(@Path("id") String id);


    @GET("products/related/{id}")
    Call<RelatedProducts> getRelatedProducts(@Path("id") String id);

    @GET("categories")
    Call<Categories> getAllCategories();

    @GET("products/categories/{id}")
    Call<String> getProductsByCategory(@Path("id") String id);

    @GET("banners")
    Call<BannerData> getBanners();

    @POST("auth/signup")
    Call<SignUp> userSignUp(@Body SignUp signUp);

    @POST("auth/login")
    Call<Login> userLogin(@Body Login login);

}
