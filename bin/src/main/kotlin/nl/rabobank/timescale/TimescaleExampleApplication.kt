package nl.rabobank.timescale

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TimescaleExampleApplication

fun main(args: Array<String>) {
	runApplication<TimescaleExampleApplication>(*args)
}
