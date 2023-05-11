package `in`.hahow.android_recruit_project.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.data.model.CourseItem

// item view
@Composable
fun ItemCard(courseItem: CourseItem) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(courseItem.coverImageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .size(width = 150.dp, height = 100.dp)
                )
                Text(
                    text = if (courseItem.status == "INCUBATING") "募資中" else "已開課",
                    color = Color.White,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 14.dp,
                                bottomEnd = 14.dp
                            )
                        )
                        .background(
                            color = if (courseItem.status == "INCUBATING") colorResource(id = R.color.primary)
                            else colorResource(id = R.color.second)
                        )
                        .align(Alignment.BottomEnd)
                        .padding(
                            start = 10.dp,
                            top = 6.dp,
                            end = 10.dp,
                            bottom = 6.dp
                        )
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = courseItem.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
            }
        }
    }
}