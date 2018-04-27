package org.appeyroad.s13.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_editor.*
import org.appeyroad.s13.todo.models.ToDo

class EditorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        submit.setOnClickListener { view ->
            val content = content.text.toString()
            val realm = Realm.getDefaultInstance()
            val todo = realm.createObject<ToDo>()
            todo.content = content
        }
    }
}
