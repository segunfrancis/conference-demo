package com.segunfrancis.conferencedemo.controllers

import com.segunfrancis.conferencedemo.models.Speaker
import com.segunfrancis.conferencedemo.repositories.SpeakerRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/speakers")
class SpeakersController {

    @Autowired
    private lateinit var speakerRepository: SpeakerRepository

    @GetMapping
    fun list(): List<Speaker> {
        return speakerRepository.findAll()
    }

    @GetMapping
    @RequestMapping("{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Speaker> {
        if (speakerRepository.findById(id).isPresent.not()) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(speakerRepository.getOne(id), HttpStatus.OK)
    }

    @PostMapping
    fun create(@RequestBody speaker: Speaker): Speaker {
        return speakerRepository.saveAndFlush(speaker)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: Long) {
        speakerRepository.deleteById(id)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody speaker: Speaker): Speaker {
        val existingSpeaker = speakerRepository.getOne(id)
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id")
        return speakerRepository.saveAndFlush(existingSpeaker)
    }
}
