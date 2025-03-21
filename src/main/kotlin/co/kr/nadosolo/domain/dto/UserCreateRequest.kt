package co.kr.nadosolo.domain.dto

import co.kr.nadosolo.domain.constant.Gender

data class UserCreateRequest(
    val name: String,
    val password: String,
    val email: String,
    val birthDate: String,
    val gender: Gender
)
