package com.jinwoo.todolist.TodoList.service

import com.jinwoo.todolist.TodoList.entity.Todo
import com.jinwoo.todolist.TodoList.repository.TodoModel

interface TodoService {
    fun getTodoList(): List<TodoModel>

    fun getTodo(todoId: Int): TodoModel?

    fun createTodo(todo: Todo): TodoModel

    fun updateTodo(todo: Todo, todoId: Int): TodoModel

    fun deleteTodo(todoId: Int): TodoModel?
}