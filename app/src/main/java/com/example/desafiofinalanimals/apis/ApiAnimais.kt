package com.example.desafiofinalanimals.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAnimais (private val baseUrl: String) {

    fun create(): RoutesApiAnimals { // retornar a biblioteca Retrifit
        return Retrofit
            .Builder() // O construtor,Avisa que algo vai ser construído
            .baseUrl(baseUrl) // Atribuião da base url
            .addConverterFactory(GsonConverterFactory.create()) // Criação do conversor de JSON para classe kotlin
            .client(OkHttpClient.Builder().build()) // Atribuição do agente que irá efetuar a requisição em si
            .build() // termino de construir com o build
            .create(RoutesApiAnimals::class.java) // crio a minha URL com a end point //  é a junção da URL com o endpoint
    }
}



