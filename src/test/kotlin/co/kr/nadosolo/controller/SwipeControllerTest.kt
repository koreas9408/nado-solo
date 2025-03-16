package co.kr.nadosolo.controller

import co.kr.nadosolo.domain.constant.Direction
import co.kr.nadosolo.domain.entity.Swipe
import co.kr.nadosolo.dto.SwipeDTO
import co.kr.nadosolo.service.SwipeService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@DisplayName("[스와이프 API 컨트롤러 테스트]")
class SwipeControllerTest {
    @Mock
    lateinit var swipeService: SwipeService

    @InjectMocks
    lateinit var swipeController: SwipeController

    private fun createSwipe(): SwipeDTO {
        return SwipeDTO(
            Swipe(
                swiperId = 1L,
                swipedId = 2L,
                direction = Direction.LIKE,
                isSuperLike = true
            )
        )
    }

    @Test
    @DisplayName("스와이프 목록 조회 API")
    fun swipes() {
        // given
        val swipes = mutableListOf<SwipeDTO>()
        swipes.add(createSwipe())

        Mockito.`when`(swipeService.findAll())
            .thenReturn(swipes)

        // when
        val controllerUsers = swipeController.swipes()

        // then
        assertEquals(swipes.size, controllerUsers.size)
    }

    @Test
    @DisplayName("스와이프 단건 조회 API")
    fun findBySwiperId() {
        // given
        val swipes = mutableListOf<SwipeDTO>()
        val swiperId = 1L
        swipes.add(createSwipe())

        Mockito.`when`(swipeService.findBySwiperId(swiperId))
            .thenReturn(swipes)

        // when
        val controllerSwipes = swipeController.findBySwiperId(swiperId)

        println("Service Swipes: ${swipes}, Controller Swipes: $controllerSwipes")

        // then
        assertEquals(swipes.size, controllerSwipes.size)
    }


}