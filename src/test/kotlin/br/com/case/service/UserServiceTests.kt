package br.com.case.service

import br.com.case.exception.UserNotFoundException
import br.com.case.model.User
import br.com.case.repository.UserRepository
import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UserServiceTest {

    private val userRepository: UserRepository = mockk();
    private val userService: UserService = UserService(userRepository);

    @Test
    fun `when user is not founded then return UserNotFoundException`(){
        val user: Optional<User> = Optional.empty()
        every { userRepository.findById(1) } returns user

        assertThrows<UserNotFoundException> { userService.get(1) }
        verify(exactly = 1) { userRepository.findById(1) }
    }
}