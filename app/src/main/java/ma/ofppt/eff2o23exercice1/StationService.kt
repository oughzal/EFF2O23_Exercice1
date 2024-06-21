package ma.ofppt.eff2o23exercice1

import retrofit2.http.GET

interface StationService {
    @GET("stat.json")
    suspend fun getStations() : List<Station>
}