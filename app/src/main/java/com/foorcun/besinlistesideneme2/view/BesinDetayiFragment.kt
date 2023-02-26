package com.foorcun.besinlistesideneme2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.foorcun.besinlistesideneme2.databinding.FragmentBesinDetayiBinding
import com.foorcun.besinlistesideneme2.viewmodel.BesinDetayiViewModel


class BesinDetayiFragment : Fragment() {

    private lateinit var viewModel : BesinDetayiViewModel

    // 1 asama. not: FragmentBesinListesiBinding ilgili fragment xml adina gore duzelt
    private var _binding: FragmentBesinDetayiBinding? = null
    private val binding get() = _binding!!



    private var besinId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
        //2 asama
        _binding = FragmentBesinDetayiBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)

            viewModel = ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
            viewModel.roomVerisiAl()

            observeLiveData()
        }

//
//        binding.besinDetayiButton.setOnClickListener{
//            val action =
//                BesinDetayiFragmentDirections.actionBesinDetayiFragmentToBesinListFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
    }


    fun observeLiveData(){
        viewModel.besinSecilen.observe(this, Observer { besin ->

            besin?.let{
                binding.besinIsmi.text = besin.isim
            }
        })
    }

    // 3 asama
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}