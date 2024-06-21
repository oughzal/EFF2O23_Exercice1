package ma.ofppt.eff2o23exercice1

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    //private const val BASE_URL = "http://10.0.2.2/eff/"
    private const val BASE_URL = "https://raw.githubusercontent.com/oughzal/EFF2O23_Exercice1/main/"
        val instance: StationService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(StationService::class.java)
    }
}