package co.kr.nadosolo.controller

import co.kr.nadosolo.domain.dto.UserCreateRequest
import co.kr.nadosolo.domain.dto.UserUpdateRequest
import co.kr.nadosolo.dto.UserDTO
import co.kr.nadosolo.service.UserService
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/users")
    fun addUser(@RequestBody request: UserCreateRequest) {
        userService.save(request)
    }

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody request: UserUpdateRequest) {
        userService.update(id, request)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.delete(id)
    }
}