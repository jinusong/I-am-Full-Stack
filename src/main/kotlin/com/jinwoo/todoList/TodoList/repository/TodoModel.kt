package com.jinwoo.todoList.TodoList.repository

import javax.persistence.*

@Entity
@Table(name = "todoList")
data class TodoModel(
        @Column(name="title")
        var title: String,
        @Column(name="content")
        var content: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    val id: Int? = null
}
