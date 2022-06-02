package br.com.case

import br.com.case.model.User
import br.com.case.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
@TestPropertySource("file:src/test/resources/application.yml")
class UserControllerTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    lateinit var userService: UserService

//    val user = User(1, )
}