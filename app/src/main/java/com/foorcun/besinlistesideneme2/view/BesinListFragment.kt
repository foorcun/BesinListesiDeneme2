package com.foorcun.besinlistesideneme2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.foorcun.besinlistesideneme2.adapter.BesinRecyclerAdapter
import com.foorcun.besinlistesideneme2.databinding.FragmentBesinListBinding
import com.foorcun.besinlistesideneme2.viewmodel.BesinListesiViewModel


class BesinListFragment : Fragment() {

    private var _binding: FragmentBesinListBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel : BesinListesiViewModel
    private val recyclerBesinAdapter = BesinRecyclerAdapter(arrayListOf()) // adapter takes Data as input then converts it into View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_besin_list, container, false)

        _binding = FragmentBesinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // en basta gone
        binding.besinHataMesaji.visibility = View.GONE
        binding.besinListYukleniyor.visibility = View.GONE

        // Navigation with Button
//        binding.besinListesiButton.setOnClickListener{
//            val action =
//                BesinListFragmentDirections.actionBesinListFragmentToBesinDetayiFragment(besinId = 3)
//            Navigation.findNavController(it).navigate(action)
//        }

        viewModel = ViewModelProviders.of(this).get(BesinListesiViewModel::class.java)
        viewModel.refreshData()

//
        binding.besinListrRecyclerView.layoutManager=LinearLayoutManager(context)
        binding.besinListrRecyclerView.adapter = recyclerBesinAdapter
        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.besinler.observe(this,Observer { besinler ->

            besinler?.let {
                binding.besinListrRecyclerView.visibility = View.VISIBLE
                recyclerBesinAdapter.besinListesiGuncelle(besinler)



            }
        })

        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer{hata ->
            hata?.let{
                if(it){
                    binding.besinHataMesaji.visibility = View.VISIBLE

                }else{
                    binding.besinHataMesaji.visibility = View.GONE
                }
            }
        })

        // YUKLENIYOR BURAYA GELCEK
        viewModel.besinYukleniyor.observe(this,Observer{loading ->
            loading?.let{
                if(it){
                    binding.besinListYukleniyor.visibility = View.VISIBLE
                }else{
                    binding.besinListYukleniyor.visibility = View.GONE
                }

            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}