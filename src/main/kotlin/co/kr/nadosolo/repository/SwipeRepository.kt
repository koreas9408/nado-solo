package co.kr.nadosolo.repository

import co.kr.nadosolo.domain.entity.Swipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SwipeRepository : JpaRepository<Swipe, Long> {
    fun findBySwiperId(swiperId: Long): List<Swipe>
}