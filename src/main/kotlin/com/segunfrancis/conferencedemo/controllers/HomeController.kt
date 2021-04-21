package com.segunfrancis.conferencedemo.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @Autowired
    private lateinit var env: Environment

    @GetMapping
    @RequestMapping("/")
    fun getStatus(): Map<String, String?> {
        val map = HashMap<String, String?>()
        val appVersion: String? = env.getProperty("app.version")
        map["app_version"] = appVersion
        return map
    }
}