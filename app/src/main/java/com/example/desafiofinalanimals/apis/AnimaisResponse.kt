package com.example.desafiofinalanimals.apis

import com.google.gson.annotations.SerializedName

class AnimaisResponse(

    @SerializedName("itens") val animals: List<Animals>
)

data class Animals(

    @SerializedName("id") val idAnimal: String,

    @SerializedName("name") val animalName: String,

    @SerializedName("description") val descriptionAnimal: String,

    @SerializedName("age") val ageAnimal: Int,

    @SerializedName("image") val imageAnimal: String,

    @SerializedName("created_at") val animalCreatedAt: String,

    @SerializedName("updated_at") val animalUpDateAt: String
)

/*
## Animals
- [GET]: https://bootcamp-ios-api.herokuapp.com/api/v1/animals
- Response
  - {
      "items": [
        {
          "id": "beed22ec-142c-46c5-bd74-3f47c00dc874",
          "name": "Animal I",
          "description": "Desc Animal I",
          "age": 10,
          "species": "Espécie Animal I",
          "image": "image Animal I",
          "created_at": "2022-06-06T19:03:10.698Z",
          "updated_at": "2022-06-06T19:03:10.698Z"
        }
      ]
    }

 */