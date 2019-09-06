package com.jinwoo.todolist.TodoList.controller

import com.jinwoo.todolist.TodoList.entity.Todo
import com.jinwoo.todolist.TodoList.repository.TodoModel
import com.jinwoo.todolist.TodoList.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController(@Autowired val todoService: TodoService) {

    @GetMapping
    fun getTodoList(): List<TodoModel>
            = todoService.getTodoList()

    @GetMapping(path = ["/{todoId}"])
    fun getTodo(@PathVariable("todoId") todoId: Int)
            = todoService.getTodo(todoId)

    @PostMapping
    fun createTodo(@RequestBody todo: Todo)
            = todoService.createTodo(todo)

    @PutMapping(path = ["/{todoId}"])
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("todoId") todoId: Int)
            = todoService.updateTodo(todo, todoId)

    @DeleteMapping(path = ["/{todoId}"])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteTodo(@PathVariable("todoId") todoId: Int)
            = todoService.deleteTodo(todoId)
}
