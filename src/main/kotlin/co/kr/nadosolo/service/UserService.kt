package co.kr.nadosolo.service

import co.kr.nadosolo.dto.UserDTO
import co.kr.nadosolo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrElse

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<UserDTO> {
        return userRepository.findAll().map { UserDTO(it) }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): UserDTO {
        val user = userRepository.findById(id).getOrElse {
            throw RuntimeException("존재하지 않는 사용자 입니다. userId : $id")
        }

        return UserDTO(user)
    }
}