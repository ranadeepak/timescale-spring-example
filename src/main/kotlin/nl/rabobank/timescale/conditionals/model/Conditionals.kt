package nl.rabobank.timescale.conditionals.model

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("conditions")
data class Conditionals(
    @Id val time: LocalDateTime? = null,
    val location: String,
    val temperature: Double,
    val humidity: Double
)