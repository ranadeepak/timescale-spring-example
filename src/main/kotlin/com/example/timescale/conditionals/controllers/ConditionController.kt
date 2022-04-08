package com.example.timescale.conditionals.controllers

import com.example.timescale.conditionals.model.Conditionals
import com.example.timescale.conditionals.services.ConditionalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/conditionals")
class ConditionController(
    val conditionalService: ConditionalService
    ) {

    @PostMapping
    suspend fun post(@RequestBody conditionals: Conditionals) {
        conditionalService.insert(conditionals)
    }

    @GetMapping("/timestamps/lt/{timestampLt}/gt/{timestampGt}")
    suspend fun get(@PathVariable("timestampLt")timeStampLt: String,
                    @PathVariable("timestampGt")timeStampGt: String): List<Conditionals> {
        return conditionalService.findByTimeStamps(timeStampLt, timeStampGt)
    }

    @GetMapping
    suspend fun getAll(): List<Conditionals> =
        conditionalService.findAll()
}
