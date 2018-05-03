package org.appeyroad.s13.todo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import io.realm.Realm
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_editor.*
import org.appeyroad.s13.todo.models.ToDo
import java.util.*

class EditorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        submit.setOnClickListener { view ->
            val content = content.text.toString()
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction {
                val todo = realm.createObject<ToDo>(UUID.randomUUID().hashCode())
                todo.content = content
                realm.insert(todo)
            }
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.putString("draft", content.text.toString())
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        content.setText(savedInstanceState?.getString("draft", ""))
        super.onRestoreInstanceState(savedInstanceState)
    }
}
