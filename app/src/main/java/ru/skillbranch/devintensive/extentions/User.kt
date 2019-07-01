package ru.skillbranch.devintensive.extentions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView{
    val nickname = Utils.transliterations("$firstName $lastName")
    val initials =Utils.toInitials(firstName, lastName)
    val status =if (lastVisit == null) "Еще ни разу не был" else if(isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

        return UserView(
            id = id,
            fullName = "$firstName $lastName",
            nickName = nickname,
            avatar = avatar,
            initials = initials,
            status = status
        )
}

