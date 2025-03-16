package co.kr.nadosolo.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    var createdDateTime: LocalDateTime? = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    var modifiedDateTime: LocalDateTime? = LocalDateTime.now()
}