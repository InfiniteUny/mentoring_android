package id.infiniteuny.weekone.ui

import id.infiniteuny.weekone.model.Todo

interface TodoContract {
    fun showLoading()
    fun hideLoading()
    fun showDataTodo(listTodo: List<Todo>)
    fun showError(errorMessage: String)
}