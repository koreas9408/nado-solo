package co.kr.nadosolo.domain.entity

import co.kr.nadosolo.domain.constant.Gender
import co.kr.nadosolo.domain.dto.UserUpdateRequest
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    var name: String,
    val email: String,
    var password: String,
    var birthDate: String,
    @Enumerated(EnumType.STRING)
    val gender: Gender
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0L

    companion object {
        fun of(
            name: String,
            email: String,
            password: String,
            birthDate: String,
            gender: Gender
        ): User {
            return User(
                name = name,
                email = email,
                password = password,
                birthDate = birthDate,
                gender = gender
            )
        }
    }

    fun update(request: UserUpdateRequest) {
        this.name = request.name
        this.password = request.password
        this.birthDate = request.birthDate
    }
}