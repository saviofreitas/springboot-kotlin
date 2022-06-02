package br.com.case.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class User(var name: String = "", var document: Long = 0L) {

    @Id @GeneratedValue
    var id: Long? = null

    @CreatedDate
    val createdAt: LocalDateTime = now()

    @LastModifiedDate
    var updatedAt: LocalDateTime = now()
}