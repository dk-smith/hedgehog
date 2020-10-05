package dk.apps.hedgehog.interfaces

import dk.apps.hedgehog.objects.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("jokes/random/{count}?escape=javascript")
    fun getJokes(@Path("count") count: Int): Call<Result>

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.icndb.com/")
                .build()

            return retrofit.create(ApiService::class.java);
        }
    }

}