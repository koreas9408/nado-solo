package co.kr.nadosolo.domain.entity

import co.kr.nadosolo.domain.constant.Direction
import jakarta.persistence.*

@Entity
@Table(name = "swipes")
class Swipe(
    val swiperId: Long,
    val swipedId: Long,
    val direction: Direction,
    val isSuperLike: Boolean = false,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "swipe_id")
    val id: Long = 0L
}