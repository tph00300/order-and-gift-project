package msa.gift.interfaces.gift.api

import msa.gift.application.gift.GiftFacade
import msa.gift.common.response.CommonResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/gifts")
class GiftApiController(
    val giftDtoMapper: GiftDtoMapper,
    val giftFacade: GiftFacade
) {
    @PostMapping
    suspend fun registerOrder(
        @RequestBody @Valid request: GiftDto.RegisterOrderRequest
    ): CommonResponse<GiftDto.RegisterOrderResponse> {
        var giftCommand = giftDtoMapper.of(request)
        var giftInfo = giftFacade.registerOrder(giftCommand)
        var response = giftDtoMapper.of(giftInfo)
        return CommonResponse(response)
    }
}