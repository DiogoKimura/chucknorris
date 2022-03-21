package co.tiagoaguiar.tutorial.jokerappdev.presenter

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.RandomJokeResponse
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun getRandomJoke(){
        view.showProgress()
        dataSource.getJoke(null, this)
    }

    override fun onSuccess(response: RandomJokeResponse) { view.showJoke(response) }

    override fun onError(message: String) { view.showError(message) }

    override fun onComplete() { view.hideProgress() }


}