package com.test.viewmodellivedataroom.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.test.viewmodellivedataroom.database.AppDatabase
import com.test.viewmodellivedataroom.database.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomTestViewModel(application: Application) : AndroidViewModel(application) {
    val db = Room.databaseBuilder(application, AppDatabase::class.java, "database-name").build()
    var todos: LiveData<List<Todo>>
    var newTodo: String? = null

    init {
        todos = getAll()
    }

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(todo))
        }
    }

    fun update(todo: Todo) {
        //db.todoDao().update(todo)
    }

    fun delete(todo: Todo) {
        //db.todoDao().delete(todo)
    }
}