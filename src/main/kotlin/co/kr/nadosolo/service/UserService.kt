package co.kr.nadosolo.service

import co.kr.nadosolo.domain.dto.UserCreateRequest
import co.kr.nadosolo.domain.dto.UserUpdateRequest
import co.kr.nadosolo.domain.entity.User
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

    @Transactional
    fun save(request: UserCreateRequest) {
        // TODO:: encrypt 필요
        userRepository.save(
            User.of(
                name = request.name,
                email = request.email,
                password = request.password,
                birthDate = request.birthDate,
                gender = request.gender,
            )
        )
    }

    @Transactional
    fun update(id: Long, request: UserUpdateRequest) {
        // TODO:: encrypt 필요
        val user = userRepository.findById(id).orElseThrow {
            throw RuntimeException("${id}의 유저가 존재하지 않습니다.")
        }

        user.update(request)
    }

    @Transactional
    fun delete(id: Long) {
        // TODO:: encrypt 필요
        val user = userRepository.findById(id).orElseThrow {
            throw RuntimeException("${id}의 유저가 존재하지 않습니다.")
        }

        userRepository.delete(user)
    }

}