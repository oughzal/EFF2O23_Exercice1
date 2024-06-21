package ma.ofppt.eff2o23exercice1

import retrofit2.http.GET

interface StationService {
    @GET("index.php")
    suspend fun getStations() : List<Station>
}