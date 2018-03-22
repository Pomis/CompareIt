package pomis.app.compareit.repository

import io.reactivex.Observable
import io.reactivex.Single
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Category
import pomis.app.compareit.model.Offer
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by roman on 3/22/18.
 */
interface CompareitRouter {

    @GET("/offers")
    fun getOffers(): Observable<List<Offer>>

    @GET("/offers/{id}")
    fun getOfferById(@Path("id") id:String): Single<Offer>

    @GET("/categories") // contains nested subcategories
    fun getCategories(): Observable<List<Category>>

    @GET("/items/{scid}") // get all items for selected subcategory
    fun getItemsBySubcategory(): Observable<List<Category>>

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