package com.example.desafiofinalanimals.repository

import retrofit2.HttpException
import com.example.desafiofinalanimals.apis.ApiAnimais
import com.example.desafiofinalanimals.apis.CadastroBody
import com.example.desafiofinalanimals.apis.CadastroResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CadastroRepository {

    private var cadastroRoute = ApiAnimais ("https://bootcamp-ios-api.herokuapp.com").create()

    suspend fun doTheRegistration( // o sunpend vai fazer tudo em segundo plano usando o coroutines
        name: String, description: String, age: Int, species: String, image: String
    ): Flow<CadastroResponse>{ // o flow retorna a corrente de dados
        return flow {
            cadastroRoute.doRegistration( //Faz a requisição passando o corpo da requisição
                CadastroBody( name, description, age, species, image) // cadastro no corpo da requisição
            ).let { response ->  // esse response está na linha 14 da Interface: *RoutesApiAnimals*
                if(response.isSuccessful){  //O Response é retornado e validado
                    response.body()
                } else{
                    throw HttpException(response) // essa é uma exeção específica, como parametro coloca o response
                }?.let {
                    //Response é enviado
                    emit(it)
                }
            }
        }
    }
}