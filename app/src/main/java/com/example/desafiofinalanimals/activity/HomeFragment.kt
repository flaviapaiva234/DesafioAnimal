package com.example.desafiofinalanimals.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiofinalanimals.adapter.AdapterAnimais
import com.example.desafiofinalanimals.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterRecyclerView: AdapterAnimais
    private lateinit var viewModel: AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)
        viewModel.animalResponse.observe(viewLifecycleOwner, Observer {
            binding.recyclerViewContainerHome.apply {
                adapterRecyclerView = AdapterAnimais(it)
                layoutManager = LinearLayoutManager(context)
                adapter = adapterRecyclerView
            }
        })
        viewModel.getAnimal()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}