package com.example.kotlin_btk_10.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_btk_10.databinding.FragmentBesinDetayBinding
import com.example.kotlin_btk_10.util.gorselIndir
import com.example.kotlin_btk_10.util.placeHolderYap
import com.example.kotlin_btk_10.viewmodel.BesinDetayViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [BesinDetayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BesinDetayFragment : Fragment() {

    private var _binding: FragmentBesinDetayBinding? = null
    private  val binding get() = _binding!!
    private  lateinit var viewModel: BesinDetayViewModel
    var besinId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBesinDetayBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this)[BesinDetayViewModel::class.java]

      arguments?.let {
         besinId  = BesinDetayFragmentArgs.fromBundle(it).besinid
      }

        viewModel.roomVerisiniAl(besinId)
        observeLiveData()

    }

    private  fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner){
            binding.besinIsim.text = it.isim
            binding.besinKalori.text = it.kalori
            binding.besinKarbonhidrat.text = it.karbonhidrat
            binding.besinProtein.text = it.protein
            binding.besinYa.text = it.yag
            binding.besinImage.gorselIndir(it.gorsel, placeHolderYap(requireContext()))

        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}