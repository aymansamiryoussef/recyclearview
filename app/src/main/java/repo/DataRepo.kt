package repo

import network.Api
import network.RetrofitClient

class DataRepo {
    fun getMyApi(): Api? {
       val myApiResponse = RetrofitClient.getInstance().create(Api::class.java)
        return myApiResponse
    }
}