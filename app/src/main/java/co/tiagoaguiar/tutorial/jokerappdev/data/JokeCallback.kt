package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.RandomJokeResponse

interface JokeCallback {
    fun onSuccess(response: RandomJokeResponse)

    fun onError(message: String)

    fun onComplete()
}