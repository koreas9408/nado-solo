package co.kr.nadosolo.service

import co.kr.nadosolo.domain.constant.Direction
import co.kr.nadosolo.domain.entity.Swipe
import co.kr.nadosolo.repository.SwipeRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
@DisplayName("스와이프 서비스 테스트")
class SwipeServiceTest {
    @Mock
    lateinit var swipeRepository: SwipeRepository

    @InjectMocks
    lateinit var swipeService: SwipeService

    // 테스트 스와이프 생성 메서드
    private fun createSwipe(): Swipe {
        return Swipe(
            swiperId = 1L, swipedId = 2L, direction = Direction.DISLIKE, isSuperLike = true
        )
    }

    @Test
    @DisplayName("* 라이크 * 목록만 보여준다.")
    fun findBySwiperId() {
        // given
        val swiperId = 1L
        val swipes = mutableListOf<Swipe>()
        swipes.add(createSwipe())

        Mockito.`when`(swipeRepository.findBySwiperId(swiperId)).thenReturn(swipes)

        // when
        val serviceSwipes = swipeService.findBySwiperId(swiperId)

        // then
        assertThat(serviceSwipes).hasSize(0)
    }
}