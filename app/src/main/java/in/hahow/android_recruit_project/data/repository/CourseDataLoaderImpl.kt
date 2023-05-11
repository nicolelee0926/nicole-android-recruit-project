package `in`.hahow.android_recruit_project.data.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import `in`.hahow.android_recruit_project.data.model.CourseResult
import `in`.hahow.android_recruit_project.data.model.Result
import `in`.hahow.android_recruit_project.domain.repository.CourseDataLoader
import java.io.IOException

class CourseDataLoaderImpl(private val context: Context) : CourseDataLoader {

    companion object {
        private const val TAG = "CourseDataLoaderImpl"
    }

    // get course result from file and implement data loader
    override fun getCourseResult(): Result<CourseResult> {
        var jsonString = ""
        try {
            jsonString = context.assets.open("data.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
        } catch (ioException: IOException) {
            Log.d(TAG, "getDataResult ioException: $ioException")
        }

        val course = object : TypeToken<CourseResult>() {}.type
        val courseResult: CourseResult = Gson().fromJson(jsonString, course)
        return Result.Success(courseResult)
    }
}