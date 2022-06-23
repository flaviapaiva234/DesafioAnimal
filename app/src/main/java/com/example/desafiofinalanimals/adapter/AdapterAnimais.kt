package com.example.desafiofinalanimals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.desafiofinalanimals.activity.HomeFragment
import com.example.desafiofinalanimals.apis.AnimaisResponse
import com.example.desafiofinalanimals.apis.Animals
import com.example.desafiofinalanimals.databinding.LayoutImagensRecyclerViewBinding

//1tem que implementar
class AdapterAnimais(val animaisListados: AnimaisResponse): RecyclerView.Adapter<AdapterAnimais.ViewHolderImagensListadas>() {


     class ViewHolderImagensListadas(val layout : LayoutImagensRecyclerViewBinding) :
         RecyclerView.ViewHolder(layout.root){

             fun onBind(animaisInformados: Animals) {
                 layout.tvNomeRecyclerView.text = animaisInformados.animalName
                 layout.tvDescricaoRecyclerView.text = animaisInformados.descriptionAnimal
                 layout.imageviewImagensRecyclerView.load(animaisInformados.imageAnimal)
             }
         }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImagensListadas {

        val itemBinding = LayoutImagensRecyclerViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolderImagensListadas(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolderImagensListadas, position: Int) {

        val item = animaisListados.animals[position]
        holder.onBind(item)
        holder.itemView.setOnClickListener {
            val action = HomeFragment.HomeFragmentToCadastroFragmente()
            with(holder) {
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int = animaisListados.animals.size


}