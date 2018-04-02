package pomis.app.compareit.repository

import io.reactivex.Observable
import io.reactivex.Single
import pomis.app.compareit.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface CompareitRouter {

    @GET("offers")
    fun getOffers(): Observable<List<Offer>>

    @GET("categories") // contains nested types
    fun getCategories(): Observable<List<ProductCategory>>

    @GET("categories/{cid}")
    fun getCategory(@Path("cid") cid: Int): Observable<ProductCategory>

    @GET("products/{tid}") // get all products for selected type
    fun getProductsByType(@Path("tid") tid:String): Observable<List<Product>>
//
//    @GET("/baskets")
//    fun getBaskets(): Observable<List<Basket>>
//
//    @POST("/baskets/create")
//    fun postBasket(@Body basket: Basket): Call<Void>
//
//    @POST("/baskets/{id}/add")
//    fun addToBasket(@Body product: Product): Call<Void>

    @POST("products/search")
    fun search(@Body string: String): Observable<List<Product>>

    @POST("baskets/compare")
    fun compare(@Body basket: Basket): Observable<List<Store>>

    companion object Factory {
        fun create(): CompareitRouter {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://10.0.2.2:8080/api/")
                    .build()

            return retrofit.create(CompareitRouter::class.java)
        }
    }
}