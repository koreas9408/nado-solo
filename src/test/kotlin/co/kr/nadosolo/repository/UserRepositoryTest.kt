package co.kr.nadosolo.repository

import co.kr.nadosolo.domain.constant.Gender
import co.kr.nadosolo.domain.entity.User
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
class UserRepositoryTest(
    @Autowired val userRepository: UserRepository
) {
    // 테스트 유저 생성 메서드
    private fun createUser(): User {
        return User(
            name = "테스트 유저",
            email = "test@gmail.com",
            password = "test1234!@",
            birthDate = "19940404",
            gender = Gender.MALE
        )
    }

    // 테스트 실행 전 초기 데이터를 생성 해준다.
    @BeforeAll
    fun setup() {
        println("초기 데이터 생성")
        userRepository.save(createUser())
    }

    @Test
    @DisplayName("전체 유저 목록을 조회한다.")
    fun findByAll() {
        // given
        // when
        val users = userRepository.findAll()
        users.forEach { println("name = ${it.name}, email = ${it.email}, password = ${it.password}, gender = ${it.gender}") }

        // then
        assertThat(users).hasSize(1)
    }

    @Test
    @DisplayName("유저 Id로 유저를 조회한다.")
    fun findById() {
        // given
        val userId = 1L

        // when
        val user = userRepository.findById(userId)

        // then
        assertEquals(userId, user.get().id)
    }

}