package com.jinwoo.todoList.TodoList.repository

import javax.persistence.*

@Entity
@Table(name = "todoList")
data class TodoModel(
        var title: String,
        var content: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    val id: Int? = null
}
