package com.example.desafiofinalanimals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofinalanimals.apis.AnimaisResponse
import com.example.desafiofinalanimals.apis.Animals
import com.example.desafiofinalanimals.databinding.LayoutImagensRecyclerViewBinding

class AdapterAnimais(val animaisListados: AnimaisResponse): RecyclerView.Adapter<AdapterAnimais.ViewHolderImagensListadas>() {


     class ViewHolderImagensListadas(val layout : LayoutImagensRecyclerViewBinding) :
         RecyclerView.ViewHolder(layout.root)


}