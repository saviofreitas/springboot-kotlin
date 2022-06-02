package br.com.case.service

import br.com.case.exception.UserNotFoundException
import br.com.case.model.User
import br.com.case.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

    fun save(user: User) : User = repository.save(user)

    fun get(id : Long) : User = repository.findById(id).orElseThrow { UserNotFoundException("User not found") }

    fun update(id: Long, user: User): User {
        var updated = get(id)
        updated.apply {
            name = user.name
            document = user.document
        }
        return save(updated)
    }
}