package com.shutdown.demo

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.router
import java.time.Duration

@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
class DemoApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(DemoApplication::class.java)
        .initializers(ApplicationContextInitializer<GenericApplicationContext> { ctx ->
            beans {
                bean {
                    router {
                        GET("/ping") {
                            noContent().build().delayElement(Duration.ofSeconds(30))
                        }
                    }
                }
            }.initialize(ctx)
        })
        .build()
        .run(*args)
}

