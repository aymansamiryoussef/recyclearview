package android.example.recyclearview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity(), NewsItemClicked {
    lateinit var newRecyclerView: RecyclerView
    lateinit var myadpter:customAdpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecyclerView = findViewById(R.id.Recyclerview)

        newRecyclerView.layoutManager = LinearLayoutManager(this)
        fetchdata()
        myadpter= customAdpter(this)
        newRecyclerView.adapter=myadpter




    }

    private fun fetchdata()
    {
        val url ="https://newsapi.org/v2/everything?q=apple&from=2022-09-07&to=2022-09-07&sortBy=popularity&apiKey=ae542ceea49f47f0a95d35a1c706defe"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {

                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<news>()
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = news(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }

                myadpter.updateNews(newsArray)
            },
            Response.ErrorListener {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)


    }

    override fun onItemClicked(item: news) {
        val builder =  CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.Url))
    }


}