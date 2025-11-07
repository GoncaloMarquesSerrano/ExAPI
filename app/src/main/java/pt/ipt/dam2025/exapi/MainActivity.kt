package pt.ipt.dam2025.exapi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import pt.ipt.dam2025.exapi.adapter.FactListAdapter
import pt.ipt.dam2025.exapi.retrofit.RetrofitInitializer
import pt.ipt.dam2025.exapi.model.Fact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnReload).setOnClickListener {
            loadFacts()
        }
        loadFacts()
    }

    private fun loadFacts() {
        val call = RetrofitInitializer().factService().list()
        call.enqueue(object : Callback<Fact.DogFactResponse> {
            override fun onResponse(
                call: Call<Fact.DogFactResponse>,
                response: Response<Fact.DogFactResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.data?.let { facts ->
                        configureList(facts)
                    }
                } else {
                    Log.e("API", "Erro: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Fact.DogFactResponse>, t: Throwable) {
                Log.e("API", "Falha: ${t.message}")
            }
        })
    }

    private fun configureList(facts: List<Fact.DogFact>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = FactListAdapter(facts, this)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
    }
}