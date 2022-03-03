package nl.rabobank.timescale.conditionals.repositories

import nl.rabobank.timescale.conditionals.model.Conditionals
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ConditionReactiveRepository : CoroutineCrudRepository<Conditionals, String> {
    suspend fun findAllByTimeGreaterThanAndTimeLessThan(gt: LocalDateTime, lt: LocalDateTime): List<Conditionals>
}