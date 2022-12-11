package com.sofia.revio.service.client

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(value = "auth", url = "\${auth.url}")
interface AuthClient {

}