package co.kr.nadosolo.controller

import co.kr.nadosolo.domain.constant.Gender
import co.kr.nadosolo.domain.entity.User
import co.kr.nadosolo.dto.UserDTO
import co.kr.nadosolo.service.UserService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@DisplayName("[유저 API 컨트롤러 테스트]")
class UserControllerTest {
    @Mock
    lateinit var userService: UserService

    @InjectMocks
    lateinit var userController: UserController

    private fun createUser(): UserDTO {
        return UserDTO(
            User(
                name = "테스트 유저",
                email = "test@gmail.com",
                password = "test1234!@",
                birthDate = "19940404",
                gender = Gender.MALE
            )
        )
    }

    @Test
    @DisplayName("유저 목록 조회 API")
    fun users() {
        // given
        val users = mutableListOf<UserDTO>()
        users.add(createUser())

        // Mockito를 이용해서 userService의 결과를 미리 저장한다.
        // Controller는 Mockito의 userService와 동일한 결과여야 테스트 통과
        Mockito.`when`(userService.findAll())
            .thenReturn(users)

        // when
        val controllerUsers = userController.users()

        // then
        assertEquals(users.size, controllerUsers.size)
    }

    @Test
    @DisplayName("유저 단건 조회 API")
    fun findById() {
        // given
        val userId = 1L
        val user = createUser()

        Mockito.`when`(userService.findById(userId))
            .thenReturn(user)

        // when
        val controllerUser = userController.user(userId)

        // then
        assertEquals(user.name, controllerUser.name)
    }


}