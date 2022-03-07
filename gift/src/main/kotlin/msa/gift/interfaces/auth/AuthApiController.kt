package msa.gift.interfaces.auth

import msa.gift.application.auth.AuthFacade
import msa.gift.common.response.CommonResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthApiController(
    val authFacade: AuthFacade
) {

    @PostMapping("/login")
    suspend fun login(@RequestBody request: AuthDto.LoginRequest): CommonResponse<AuthDto.LoginResponse> {
        val token = authFacade.login(request.loginId, request.password)
        return CommonResponse(AuthDto.LoginResponse(token))
    }
}