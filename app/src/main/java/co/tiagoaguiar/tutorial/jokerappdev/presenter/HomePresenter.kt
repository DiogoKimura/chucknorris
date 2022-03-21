package co.tiagoaguiar.tutorial.jokerappdev.presenter

import android.graphics.Color
import android.os.Looper
import android.os.Handler
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories(){
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>){
        val start = 40.0f
        val end = 190.0f
        val diff = (end - start) / response.size
        val categories = response.mapIndexed { index, value ->
            val hsv = floatArrayOf(
                (start + (diff * index)),
                100.0f,
                100.0f,
            )
            Category(value, Color.HSVToColor(hsv).toLong())
        }

        view.showCategories(categories)
    }

    override fun onError(message: String){
        view.showError(message)
    }

    override fun onComplete() {view.hideProgress()}
}