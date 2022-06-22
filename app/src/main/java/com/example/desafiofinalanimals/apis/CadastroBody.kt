package com.example.desafiofinalanimals.apis

data class CadastroBody(
    val name: String,
    val description: String,
    val age: Int,
    val species: String,
    val image: String
)
