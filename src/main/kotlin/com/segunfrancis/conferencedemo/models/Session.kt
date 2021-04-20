package com.segunfrancis.conferencedemo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity(name = "sessions")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var session_id: Long? = null,
    var session_name: String? = null,
    var session_description: String? = null,
    var session_length: Int? = null,
    @ManyToMany
    @JoinTable(
        name = "session_speakers",
        joinColumns = [JoinColumn(name = "session_id")],
        inverseJoinColumns = [JoinColumn(name = "speaker_id")]
    )
    var speakers: List<Speaker>? = null
)
