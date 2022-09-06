package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private var instance: RetrofitClient? = null
    private var myApi: Api? = null


    companion object{
        fun getInstance() :Retrofit {
            val retrofit: Retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit

        }
    }


    @Synchronized
    fun getInstance(): RetrofitClient? {
        if (instance == null) {
            instance = RetrofitClient()
        }
        return instance
    }


}