package android.example.recyclearview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.heddermodel
import network.Api
import network.RetrofitClient
import retrofit2.*

class MainActivity : AppCompatActivity() {
    lateinit var newRecyclerView: RecyclerView
    lateinit var newArraylist: ArrayList<word>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testmyapi()
        newArraylist = ArrayList<word>()
        val a = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val b = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val c = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val d = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val f = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val g = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val h = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val x = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val z = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        val l = word(R.drawable.android, "asdasdad", "asdfsafsaf")
        newArraylist.add(a)
        newArraylist.add(b)
        newArraylist.add(c)
        newArraylist.add(d)
        newArraylist.add(f)
        newArraylist.add(g)
        newArraylist.add(h)
        newArraylist.add(x)
        newArraylist.add(z)
        newArraylist.add(l)

        newRecyclerView = findViewById(R.id.Recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        newRecyclerView.adapter = customAdpter(newArraylist)

    }

    fun testmyapi() {
        val r: Retrofit = RetrofitClient.getInstance()
        val response = r.create(Api::class.java)
        val callback = response.getsuperHeroes()
        callback?.enqueue(object : Callback<heddermodel> {
            override fun onResponse(call: Call<heddermodel>?, response2: Response<heddermodel>?) {

                Log.e("MainActivity", "Response is  Sucess---->" +   response2?.body()?.acceptEncoding)
            }
            override fun onFailure(call: Call<heddermodel>, t: Throwable) {
                Log.e("MainActivity", "Response is  Failer---->" + t?.message.toString())
            }
        })

    }
}