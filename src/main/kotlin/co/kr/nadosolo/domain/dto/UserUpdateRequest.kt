package co.kr.nadosolo.domain.dto

data class UserUpdateRequest(
    val name: String,
    val password: String,
    val birthDate: String
)
