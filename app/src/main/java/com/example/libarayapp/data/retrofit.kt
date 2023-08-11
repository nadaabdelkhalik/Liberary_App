import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {
    private  fun instance()

            = Retrofit.Builder().baseUrl("https://www.googleapis.com/books/v1/").addConverterFactory(
        GsonConverterFactory.create()).build()

    fun apiServiceInstance():ApiService= instance().create(ApiService::class.java)

}