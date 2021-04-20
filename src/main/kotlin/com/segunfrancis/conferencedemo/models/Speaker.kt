package com.segunfrancis.conferencedemo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Type
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.ManyToMany

@Entity(name = "speakers")
//@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
data class Speaker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var speaker_id: Long? = null,
    var first_name: String? = null,
    var last_name: String? = null,
    var title: String? = null,
    var company: String? = null,
    var speaker_bio: String? = null,

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    var speaker_photo: ByteArray? = null,

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    var sessions: List<Session>? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Speaker

        if (speaker_id != other.speaker_id) return false
        if (first_name != other.first_name) return false
        if (last_name != other.last_name) return false
        if (title != other.title) return false
        if (company != other.company) return false
        if (speaker_bio != other.speaker_bio) return false
        if (speaker_photo != null) {
            if (other.speaker_photo == null) return false
            if (!speaker_photo.contentEquals(other.speaker_photo)) return false
        } else if (other.speaker_photo != null) return false
        if (sessions != other.sessions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = speaker_id?.hashCode() ?: 0
        result = 31 * result + (first_name?.hashCode() ?: 0)
        result = 31 * result + (last_name?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (company?.hashCode() ?: 0)
        result = 31 * result + (speaker_bio?.hashCode() ?: 0)
        result = 31 * result + (speaker_photo?.contentHashCode() ?: 0)
        result = 31 * result + (sessions?.hashCode() ?: 0)
        return result
    }
}
