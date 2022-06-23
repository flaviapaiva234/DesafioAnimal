package com.example.desafiofinalanimals.repository

import com.example.desafiofinalanimals.apis.ApiAnimais
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.util.concurrent.Flow
import com.example.desafiofinalanimals.apis.AnimaisResponse as AnimaisResponse1

class AnimalRepository {

    private var routesApiAnimais = ApiAnimais("https://bootcamp-ios-api.herokuapp.com").create()

    suspend fun getAnimals(): Flow<AnimaisResponse1>{
        return flow<AnimaisResponse1> {
            routesApiAnimais.getAnimal().let { response ->
               if (response.isSuccessful){
                   response.body()
               }else{
                   throw HttpException(response)
               }

            }?.let {
                emit(it)
            }
        }
    }
}