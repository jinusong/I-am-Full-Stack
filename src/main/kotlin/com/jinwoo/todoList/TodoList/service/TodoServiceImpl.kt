package com.jinwoo.todolist.TodoList.service

import com.jinwoo.todolist.TodoList.entity.Todo
import com.jinwoo.todolist.TodoList.repository.TodoModel
import com.jinwoo.todolist.TodoList.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(val todoRepository: TodoRepository): TodoService {
    override fun getTodoList(): List<TodoModel>
            = todoRepository.findAll()

    override fun getTodo(todoId: Int): TodoModel?
            = todoRepository.findByIdOrNull(todoId)

    override fun createTodo(todo: Todo): TodoModel {
        val model = TodoModel(todo.title, todo.content)
        todoRepository.save(model)
        return model
    }

    override fun updateTodo(todo: Todo, todoId: Int): TodoModel {
        val model: TodoModel = todoRepository.findById(todoId).get()

        model.title = todo.title
        model.content = todo.content

        todoRepository.save(model)

        return model
    }

    override fun deleteTodo(todoId: Int): TodoModel? {
        todoRepository.deleteById(todoId)
        return getTodo(todoId)
    }
}