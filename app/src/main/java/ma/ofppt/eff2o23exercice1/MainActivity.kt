package ma.ofppt.eff2o23exercice1

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var stations: ArrayList<Station> = ArrayList()
    lateinit var lv: ListView
    lateinit var txtTel: TextView
    lateinit var txpriG: TextView
    lateinit var txpriEs: TextView
    lateinit var swAdditif: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lv = findViewById(R.id.lv)
        txtTel = findViewById(R.id.txtTel)
        txpriG = findViewById(R.id.txpriG)
        txpriEs = findViewById(R.id.txpriEs)
        swAdditif = findViewById(R.id.swAdditif)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fetchStations()
    }

    fun fetchStations() {
        lifecycleScope.launch(Dispatchers.Main) {
            stations.clear()
            val stats = RetrofitClient.instance.getStations()
            stations.addAll(stats)
            val adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_list_item_1,
                stations.map { it.station }
            )
            lv.adapter = adapter
            lv.setOnItemClickListener { _, _, position, _ ->
                val selectedStation = stations[position]
                txtTel.text = selectedStation.tel
                txpriG.text = selectedStation.prixgasoil.toString()
                txpriEs.text = selectedStation.prixessence.toString()
                swAdditif.isChecked = selectedStation.AvecAdditif

            }
        }
    }
}