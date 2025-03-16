package co.kr.nadosolo.controller

import co.kr.nadosolo.dto.UserDTO
import co.kr.nadosolo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/users")
    fun users(): List<UserDTO> {
        return userService.findAll()
    }

    @GetMapping("/users/{id}")
    fun user(@PathVariable id: Long): UserDTO {
        return userService.findById(id)
    }
}