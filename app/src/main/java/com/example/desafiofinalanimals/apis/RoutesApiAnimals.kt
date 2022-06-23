package com.example.desafiofinalanimals.apis

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RoutesApiAnimals {


    //Requisição vai acontecer em segundo plano, através do método @POST
    @POST("/api/v1/animals")
    suspend fun doRegistration(
        @Body body: CadastroBody
  ): Response<CadastroResponse>

    @GET("/api/v1/animals")
    suspend fun getAnimal(): Response<AnimaisResponse>
}