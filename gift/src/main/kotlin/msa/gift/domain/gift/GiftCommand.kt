package msa.gift.domain.gift


class GiftCommand {
    class RegisterOrder(
        var buyerUserId: String,
        var payMethod: String,
        var pushType: String,
        var giftReceiverName: String,
        var giftReceiverPhone: String,
        var giftMessage: String,
        var orderItemList: List<RegisterOrderItem>
    ) {
        fun toEntity(orderToken: String): Gift {
            return Gift(
                buyerUserId = buyerUserId,
                orderToken = orderToken,
                pushType = Gift.PushType.valueOf(pushType),
                giftReceiverName = giftReceiverName,
                giftReceiverPhone = giftReceiverPhone,
                giftMessage = giftMessage
            )
        }
    }

    class RegisterOrderItem(
        var orderCount: Int,
        var itemToken: String,
        var itemName: String,
        var itemPrice: Long,
        var orderItemOptionGroupList: List<RegisterOrderItemOptionGroup>
    )

    class RegisterOrderItemOptionGroup(
        var ordering: Int,
        var itemOptionGroupName: String,
        var orderItemOptionList: List<RegisterOrderItemOption>
    )

    class RegisterOrderItemOption(
        var ordering: Int,
        var itemOptionName: String,
        var itemOptionPrice: Long
    )
}