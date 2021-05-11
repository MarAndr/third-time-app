package com.example.task1

fun main() {
    val tester = Employee(7, Vacancy("Developer"))
    println(tester.getId())
    println(tester.getVacancy())
}

class Employee(private val id: Long, private val vacancy: Vacancy) {

    fun getVacancy(): String {
        return vacancy.getVacancy()
    }

    fun getId(): Long {
        return id
    }
}

class Vacancy(private val name: String) {

    fun getVacancy(): String {
        return name
    }
}