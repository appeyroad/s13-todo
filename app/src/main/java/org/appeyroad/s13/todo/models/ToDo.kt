package org.appeyroad.s13.todo.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ToDo(
        @PrimaryKey var id: Long = 0,
        var content: String = ""
) : RealmObject() {

}
