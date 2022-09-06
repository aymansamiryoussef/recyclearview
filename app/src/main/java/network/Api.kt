package network
import model.heddermodel
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    companion object{
       const val  BASE_URL = "https://httpbin.org"

    }

    @GET("/get")
    fun getsuperHeroes(): Call<heddermodel>?
}