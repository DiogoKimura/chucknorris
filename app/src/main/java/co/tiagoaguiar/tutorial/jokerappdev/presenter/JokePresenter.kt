package co.tiagoaguiar.tutorial.jokerappdev.presenter

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.RandomJokeResponse
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun getJoke(category: String){
        view.showProgress()
        dataSource.getJoke(category, this)
    }

    override fun onSuccess(response: RandomJokeResponse) { view.showJoke(response) }

    override fun onError(message: String) { view.showError(message) }

    override fun onComplete() { view.hideProgress() }


}