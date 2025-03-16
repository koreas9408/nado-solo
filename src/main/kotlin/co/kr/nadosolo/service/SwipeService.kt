package co.kr.nadosolo.service

import co.kr.nadosolo.domain.constant.Direction
import co.kr.nadosolo.dto.SwipeDTO
import co.kr.nadosolo.repository.SwipeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SwipeService(
    private val swipeRepository: SwipeRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<SwipeDTO> {
        return swipeRepository.findAll().map { SwipeDTO(it) }
    }

    /**
     * 정책) 유저가 라이크한 것만 보여준다.
     */
    @Transactional(readOnly = true)
    fun findBySwiperId(id: Long): List<SwipeDTO> {
        return swipeRepository.findBySwiperId(id)
            .filter { it.direction == Direction.LIKE }.map { SwipeDTO(it) }
    }
}