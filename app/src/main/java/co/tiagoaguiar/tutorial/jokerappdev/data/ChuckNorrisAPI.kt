package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.RandomJokeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(
        @Query("apiKey") apiKey: String = HTTPClient.API_KEY): Call<List<String>>

    @GET("jokes/random")
    fun getJoke(
        @Query("category") category: String? = null,
        @Query("apiKey") apiKey: String = HTTPClient.API_KEY
    ): Call<RandomJokeResponse>

}