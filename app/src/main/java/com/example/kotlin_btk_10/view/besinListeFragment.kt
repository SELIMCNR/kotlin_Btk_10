package com.example.kotlin_btk_10.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_btk_10.adapter.besinRecyclerAdapter
import com.example.kotlin_btk_10.databinding.FragmentBesinListeBinding
import com.example.kotlin_btk_10.service.BesinAPI
import com.example.kotlin_btk_10.viewmodel.BesinListesiViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class besinListeFragment : Fragment() {

    private var _binding: FragmentBesinListeBinding? = null
    private  val binding get() = _binding!!
    private  lateinit var  viewModel : BesinListesiViewModel
    private  val besinRecyclerAdapter = besinRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().getSharedPreferences("com.example.kotlin_btk_10", 0)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBesinListeBinding.inflate(inflater, container, false)
        val view = binding.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(BesinListesiViewModel::class.java)
        viewModel.refreshData()

        binding.besinrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.besinrecyclerView.adapter = besinRecyclerAdapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.besinHataMesaji.visibility = View.GONE
            binding.besinrecyclerView.visibility = View.GONE
            binding.besinYukleniyor.visibility = View.VISIBLE
            viewModel.refreshDataFromInternet()
            binding.swipeRefreshLayout.isRefreshing = false

        }

        oberveLiveData()


    }

    private fun  oberveLiveData(){
        viewModel.besinler.observe(viewLifecycleOwner){
            besinRecyclerAdapter.besinListesiniGuncelle(it)
            binding.besinrecyclerView.visibility = View.VISIBLE
        }
        viewModel.besinHataMesaji.observe(viewLifecycleOwner){
            if (it){
                binding.besinHataMesaji.visibility = View.VISIBLE
                binding.besinrecyclerView.visibility = View.GONE
            }
            else {
                binding.besinHataMesaji.visibility = View.GONE
            }
        }
        viewModel.besinYukleniyor.observe(viewLifecycleOwner){
            if (it){
                binding.besinrecyclerView.visibility = View.GONE
                binding.besinHataMesaji.visibility = View.GONE
                binding.besinYukleniyor.visibility = View.VISIBLE

            }
            else {
                binding.besinYukleniyor.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}