package com.segunfrancis.conferencedemo.repositories

import com.segunfrancis.conferencedemo.models.Speaker
import org.springframework.data.jpa.repository.JpaRepository

interface SpeakerRepository : JpaRepository<Speaker, Long>
