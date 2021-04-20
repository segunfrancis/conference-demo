package com.segunfrancis.conferencedemo.controllers

import com.segunfrancis.conferencedemo.models.Session
import com.segunfrancis.conferencedemo.repositories.SessionRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sessions")
class SessionsController {

    @Autowired
    private lateinit var sessionsRepository: SessionRepository

    @GetMapping
    fun list(): List<Session> {
        return sessionsRepository.findAll()
    }

    @GetMapping
    @RequestMapping("{id}")
    fun get(@PathVariable id: Long): Session {
        return sessionsRepository.getOne(id)
    }

    @PostMapping
    fun create(@RequestBody session: Session): Session {
        return sessionsRepository.saveAndFlush(session)
    }

    @RequestMapping(path = ["{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: Long) {
        // TODO: 20/04/2021 Check for children records before deleting
        sessionsRepository.deleteById(id)
    }

    @RequestMapping(path = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody session: Session): Session {
        // TODO: 20/04/2021 Add validation that all attributes are passed in otherwise return a 400- Bad Payload
        val existingSession = sessionsRepository.getOne(id)
        BeanUtils.copyProperties(session, existingSession, "session_id")
        return sessionsRepository.saveAndFlush(existingSession)
    }
}
