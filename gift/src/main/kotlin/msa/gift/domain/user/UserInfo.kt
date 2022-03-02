package msa.gift.domain.user

class UserInfo {
    class Main(
        var username: String,
        var enabled: Boolean,
        var roleList: List<RoleInfo>? = null
    ) {
        constructor() : this(
            "",
            true,
            null
        )

        constructor(user: User) : this(
            user.username,
            user.enabled,
            user.roles.map { RoleInfo(it.toString()) }
        )
    }

    class MainWithPassword(
        var username: String,
        var password: String,
        var enabled: Boolean,
        var roleList: List<RoleInfo>? = null
    ) {
        constructor(user: User) : this(
            user.username,
            user.password,
            user.enabled,
            user.roles.map { RoleInfo(it.toString()) }
        )
    }


    class RoleInfo(
        var role: String
    )
}