package com.example.desafiofinalanimals.viewmodel;


class AnimalViewModel : ViewModel() {


        private var animalRepository = AnimalRepository()

        //tem que declarar duas variáveis, onde uma é mutavel e a outra não
        // o underline é uma boa prática para diferenciar a variável da variavel mutavel
        private var _animaisResponse: MutableLiveData<AnimiasResponse> = MutableLiveData()// vai deixar essa variavel privada para a view model, para não deixar a view modificar ela // Aqui tem métodos para mudar a variável
        val animaisResponse: LiveData<AnimaisResponse> _animaisResponse // aqui tem métodos para observar a variável

        private var _error: MutableLiveData<String> = MutableLiveData()
        val error: LiveData<String> = _error

        // seria para recuperar os dados, mas está dando erro Haaaa
        fun getAnimal(){

        }
}
