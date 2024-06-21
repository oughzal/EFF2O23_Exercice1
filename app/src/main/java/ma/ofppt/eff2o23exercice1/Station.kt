package ma.ofppt.eff2o23exercice1

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Station(
    val station: String,
    val tel : String,
    val AvecAdditif : Boolean,
    val prixgasoil : Double,
    val prixessence : Double

)
