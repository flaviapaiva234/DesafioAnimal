package com.example.desafiofinalanimals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiofinalanimals.apis.CadastroResponse
import com.example.desafiofinalanimals.repository.CadastroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CadastroViewModel: ViewModel() {     // tem que extender a ViewModel(e importa-la) para pega-la mais abaixo na linha 29

    val repository: CadastroRepository = CadastroRepository() //essa parte não utiliza do retrofit, mas utiliza da MVVM

    //vai ter dois LiveData, se der sucesso ele vai retornar a estrutura de Json que foi montada na forma de classe
    private val _cadastroSuccess: MutableLiveData<CadastroResponse> = MutableLiveData()
    val cadastroSuccess: LiveData<CadastroResponse> = _cadastroSuccess

    // e se ser erro vai voltar uma string com uma menssagem de erro
    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    fun cadastramento(name: String, description: String, age: Int, species: String, image: String){ // tem que fazer a função do repositório que por sua vez vai fazer a chamada na API
        // tem que declara o coroutine pq tudo aquilo lá vai ser feito em segundo plano
        viewModelScope.launch(Dispatchers.IO){
            repository.doTheRegistration(name, description, age, species, image
            ).catch { exception -> // captua a exception
                _error.postValue(exception.message) // se der erro essa exception vai carregar uma menssagem de erro
            }.collect { cadastroResponse ->
                _cadastroSuccess.postValue(cadastroResponse) //esse cadastroResponse vai atribuir a Live Data _cadastroSuccess
            }
        }
    }
}