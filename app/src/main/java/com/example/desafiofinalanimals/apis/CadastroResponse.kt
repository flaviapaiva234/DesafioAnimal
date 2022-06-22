package com.example.desafiofinalanimals.apis

import com.google.gson.annotations.SerializedName

class CadastroResponse(
    @SerializedName("id") val id: String,

    @SerializedName("name") val name: String,

    @SerializedName("description") val description: String,

    @SerializedName("age") val age: Int,

    @SerializedName("species") val species: String,

    @SerializedName("image") val image: String,

    @SerializedName("creaded_at") val createdAt: String,

    @SerializedName("updated_at") val upDatedAt: String
)
