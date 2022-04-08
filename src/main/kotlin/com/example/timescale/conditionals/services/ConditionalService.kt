package com.example.timescale.conditionals.services

import kotlinx.coroutines.flow.toList
import com.example.timescale.conditionals.model.Conditionals
import com.example.timescale.conditionals.repositories.ConditionReactiveRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ConditionalService(val conditionReactiveRepository: ConditionReactiveRepository) {

    suspend fun insert(conditionals: Conditionals) {
        conditionReactiveRepository.save(conditionals)
    }

    suspend fun findByTimeStamps(timeStampLt: String, timeStampGt: String): List<Conditionals> {
        val gt = LocalDateTime.parse(timeStampGt)
        val lt = LocalDateTime.parse(timeStampLt)
        return conditionReactiveRepository.findAllByTimeGreaterThanAndTimeLessThan(gt, lt)
    }

    suspend fun findAll(): List<Conditionals> =
        conditionReactiveRepository.findAll().toList(mutableListOf())
}
