import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

        @GET("volumes")

        suspend fun getBooks(@Query("q") query: String, @Query("maxResults") maxResults: Int = 40 ): Response<JsonResult>

}



