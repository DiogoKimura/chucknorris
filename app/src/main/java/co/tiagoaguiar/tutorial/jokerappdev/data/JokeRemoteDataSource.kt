package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.RandomJokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class JokeRemoteDataSource{

    fun getJoke(category: String?, callback: JokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .getJoke(category)
            .enqueue(object: Callback<RandomJokeResponse> {
                override fun onResponse(
                    call: Call<RandomJokeResponse>?,
                    response: Response<RandomJokeResponse>
                ) {
                    if (response.isSuccessful){
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw RuntimeException("Piada não encontrada"))
                    } else {
                        val error = response.errorBody()
                        callback.onError(error.toString())
                    }

                    callback.onComplete()
                }
                override fun onFailure(call: Call<RandomJokeResponse>?, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }
}