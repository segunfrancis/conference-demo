package com.segunfrancis.conferencedemo.repositories

import com.segunfrancis.conferencedemo.models.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SessionRepository : JpaRepository<Session, Long>
