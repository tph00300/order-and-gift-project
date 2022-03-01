package msa.order.domain.user

import msa.order.common.jwt.PBKDF2Encoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    val userStore: UserStore,
    val pbkdF2Encoder: PBKDF2Encoder
) : UserService {

    @Transactional
    override suspend fun registerUser(command: UserCommand.RegisterUserRequest): UserInfo.Main {
        var initUser = command.toEntity(pbkdF2Encoder)
        var user = userStore.store(initUser)
        return UserInfo.Main(user)
    }

    @Transactional(readOnly = true)
    override suspend fun retrieveUser(username: String): UserInfo.Main {
        TODO("Not yet implemented")
    }
}