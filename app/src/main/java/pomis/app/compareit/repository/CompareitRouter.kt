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
    fun getCategory(@Path("cid") cid: Int): Single<ProductCategory>

    @GET("products/{tid}") // get all products for selected type
    fun getProductType(@Path("tid") tid: Int): Single<ProductType>

    @GET("search/{key}")
    fun search(@Path("key") key: String): Observable<SearchResult>

    @POST("baskets/compare")
    fun compare(@Body basket: Basket): Observable<List<Store>>

    @GET("stores")
    fun getStores(): Single<List<Store>>

    companion object Factory {
        val LOCALHOST: String = "http://10.0.2.2:8080/api/"
        val HEROKU_DEV: String = "https://compare-it-app.herokuapp.com/api/"
        val EATT_DEV: String = "http://eatt.eu:8090/api/"

        fun create(): CompareitRouter {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HEROKU_DEV)
                    .build()

            return retrofit.create(CompareitRouter::class.java)
        }
    }
}