package com.sofia.revio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class RevioApplication

fun main(args: Array<String>) {
	runApplication<RevioApplication>(*args)
}
