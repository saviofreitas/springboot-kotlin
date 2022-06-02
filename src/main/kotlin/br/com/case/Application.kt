package br.com.case

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("br.com.case.repository")
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
