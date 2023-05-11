package `in`.hahow.android_recruit_project.presentation.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import `in`.hahow.android_recruit_project.data.repository.CourseDataLoaderImpl
import `in`.hahow.android_recruit_project.domain.repository.CourseDataLoader

class CourseViewModel(
    app: Application,
    private val courseDataLoader: CourseDataLoader
) : AndroidViewModel(app) {

    fun getCourseResult() = courseDataLoader.getCourseResult()
}