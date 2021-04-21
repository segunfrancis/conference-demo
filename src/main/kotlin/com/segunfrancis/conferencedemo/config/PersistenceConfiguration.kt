package com.segunfrancis.conferencedemo.config

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class PersistenceConfiguration {

    /*@Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().apply {
            url("jdbc:postgresql://localhost:5432/conferencedemo")
            println("My custom datasource has been initialised and set")
        }.build()
    }*/
}
