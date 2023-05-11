package `in`.hahow.android_recruit_project.domain.repository

import `in`.hahow.android_recruit_project.data.model.CourseResult
import `in`.hahow.android_recruit_project.data.model.Result

interface CourseDataLoader {
    // define interface method
    fun getCourseResult(): Result<CourseResult>
}