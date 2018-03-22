package pomis.app.compareit.repository

import io.reactivex.Observable
import io.reactivex.Single
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Category
import pomis.app.compareit.model.Offer
import pomis.app.compareit.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface CompareitRouter {

    @GET("/offers")
    fun getOffers(): Observable<List<Offer>>

    @GET("/offers/{oid}")
    fun getOfferById(@Path("oid") oid:String): Single<Offer>

    @GET("/categories") // contains nested types
    fun getCategories(): Observable<List<Category>>

    @GET("/products/{tid}") // get all products for selected type
    fun getProductsByType(@Path("tid") tid:String): Observable<List<Product>>

    @GET("/baskets")
    fun getBaskets() :Observable<List<Basket>>

    @POST("/baskets/create")
    fun postBasket(@Body basket: Basket): Call<Void>



    companion object Factory {
        fun create(): CompareitRouter {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://localhost:8080/")
                    .build()

            return retrofit.create(CompareitRouter::class.java)
        }
    }
}