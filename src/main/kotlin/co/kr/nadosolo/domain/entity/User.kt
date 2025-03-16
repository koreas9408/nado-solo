package co.kr.nadosolo.domain.entity

import co.kr.nadosolo.domain.constant.Gender
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String,
    @Enumerated(EnumType.STRING)
    val gender: Gender
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0L
}