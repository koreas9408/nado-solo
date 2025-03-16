package co.kr.nadosolo.dto

import co.kr.nadosolo.domain.entity.Swipe
import java.time.format.DateTimeFormatter

data class SwipeDTO(
    val swiperId: String,
    val swipedId: String,
    val direction: String,
    val isSuperLike: String,
    val createdAt: String?,
    val updatedAt: String?
) {
    constructor(swipe: Swipe) : this(
        swiperId = swipe.swiperId.toString(),
        swipedId = swipe.swipedId.toString(),
        direction = swipe.direction.name,
        isSuperLike = swipe.isSuperLike.toString(),
        createdAt = swipe.createdDateTime?.format(DateTimeFormatter.ISO_DATE_TIME),
        updatedAt = swipe.modifiedDateTime?.format(DateTimeFormatter.ISO_DATE_TIME)
    )
}
