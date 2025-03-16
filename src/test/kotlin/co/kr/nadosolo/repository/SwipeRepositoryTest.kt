package co.kr.nadosolo.repository

import co.kr.nadosolo.domain.constant.Direction
import co.kr.nadosolo.domain.entity.Swipe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertEquals

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SwipeRepositoryTest(
    @Autowired val swipeRepository: SwipeRepository
) {
    // 테스트 스와이프 생성 메서드
    private fun createSwipe(): Swipe {
        return Swipe(
            swiperId = 1L,
            swipedId = 2L,
            direction = Direction.LIKE,
            isSuperLike = true
        )
    }

    @BeforeAll
    fun setup() {
        println("초기 데이터 생성")
        swipeRepository.save(createSwipe())
    }

    @Test
    @DisplayName("전체 스와이프 목록을 조회한다.")
    fun findByAll() {
        // given
        // when
        val swipes = swipeRepository.findAll()
        swipes.forEach {
            println(
                "name = ${it.swiperId}, " +
                        "email = ${it.swipedId}, " +
                        "direction = ${it.direction}, " +
                        "isSuperLike = ${it.isSuperLike}"
            )
        }

        // then
        assertThat(swipes).hasSize(1)
    }

    @Test
    @DisplayName("swiperId로 스와이퍼를 조회한다.")
    fun findById() {
        // given
        val swiperId = 1L

        // when
        val swipe = swipeRepository.findById(swiperId)

        // then
        assertEquals(swiperId, swipe.get().swiperId)
    }

}