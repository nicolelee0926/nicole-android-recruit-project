package `in`.hahow.android_recruit_project.data.model

// model
data class CourseResult(
    val `data`: List<CourseItem>
)

data class CourseItem(
    val coverImageUrl: String,
    val numSoldTickets: Int,
    val proposalDueTime: String,
    val status: String,
    val successCriteria: SuccessCriteria,
    val title: String,
    val totalVideoLengthInSeconds: Int
)

data class SuccessCriteria(
    val numSoldTickets: Int
)


