package co.kr.nadosolo.dto

import co.kr.nadosolo.domain.constant.Gender
import co.kr.nadosolo.domain.entity.User

data class UserDTO(
    val name: String,
    val email: String,
    val birthDate: String,
    val gender: Gender
) {
    constructor(user: User) : this(
        name = user.name,
        email = user.email,
        birthDate = user.birthDate,
        gender = user.gender
    )
}