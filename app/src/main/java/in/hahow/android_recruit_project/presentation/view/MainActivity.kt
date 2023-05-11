package `in`.hahow.android_recruit_project.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModelProvider
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.data.model.CourseResult
import `in`.hahow.android_recruit_project.data.model.Result
import `in`.hahow.android_recruit_project.data.repository.CourseDataLoaderImpl
import `in`.hahow.android_recruit_project.domain.repository.CourseDataLoader
import `in`.hahow.android_recruit_project.presentation.vm.CourseViewModel
import `in`.hahow.android_recruit_project.presentation.vm.CourseViewModelProviderFactory

class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private var courseResult: Result<CourseResult>? = null

    private lateinit var viewModel: CourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // define data loader implemented by data loader impl
            val courseDataLoader: CourseDataLoader = CourseDataLoaderImpl(this)
            val viewModelProviderFactory = CourseViewModelProviderFactory(application, courseDataLoader)
            viewModel = ViewModelProvider(this, viewModelProviderFactory)[CourseViewModel::class.java]
            courseResult = viewModel.getCourseResult()

            // create list lazy column view
            courseResult?.let { courseData ->
                CourseItemList(courseData)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CourseItemList(courseResult: Result<CourseResult>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Hahow")
                }
            )
        }
    ) {
        val scrollState = rememberLazyListState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.light_gray))
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = scrollState
            ) {
                when (courseResult) {
                    is Result.Success -> {
                        items(courseResult.data.data) { courseItem ->
                            ItemCard(courseItem)
                        }
                    }
                    is Result.Loading -> {
                    }
                    is Result.Error -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }
}

