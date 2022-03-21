package co.tiagoaguiar.tutorial.jokerappdev.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource{

    fun findAllCategories(callback: ListCategoryCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findAllCategories()
            .enqueue(object: Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>?,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful){
                        callback.onSuccess(response.body())
                    } else {
                        callback.onError(response.message())
                    }

                    callback.onComplete()
                }
                override fun onFailure(call: Call<List<String>>?, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }
}