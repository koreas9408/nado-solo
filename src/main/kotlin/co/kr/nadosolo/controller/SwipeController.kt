package co.kr.nadosolo.controller

import co.kr.nadosolo.dto.SwipeDTO
import co.kr.nadosolo.service.SwipeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SwipeController(
    private val swipeService: SwipeService
) {

    @GetMapping("/swipes")
    fun swipes(): List<SwipeDTO> {
        return swipeService.findAll()
    }

    @GetMapping("/swipes/{id}")
    fun findBySwiperId(@PathVariable id: Long): List<SwipeDTO> {
        return swipeService.findBySwiperId(id)
    }
}