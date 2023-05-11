package `in`.hahow.android_recruit_project.presentation.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import `in`.hahow.android_recruit_project.domain.repository.CourseDataLoader

class CourseViewModelProviderFactory(
    private val app: Application,
    private val CourseDataLoader: CourseDataLoader
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CourseViewModel(app, CourseDataLoader) as T
    }
}