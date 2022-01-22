package msa.order.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Partner(partnerName: String, businessNo: String, email: String) {
    @Id
    var id: String?= null
    var partnerToken: String? = null
    var partnerName: String? = null
    var businessNo: String? = null
    var email: String? = null
    var status: Status? = null

    enum class Status(description: String) {
        ENABLE("활성화"),
        DISABLE("비활성화")
    }

}

