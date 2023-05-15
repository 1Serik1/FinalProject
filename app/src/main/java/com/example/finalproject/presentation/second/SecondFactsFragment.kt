package com.example.finalproject.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.FragmentSecondBinding

class SecondFactsFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var secondFactsViewModel: SecondFactsViewModel

    companion object {
        val name = "name"
        val creator = "creator"
        val description = "description"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        secondFactsViewModel = ViewModelProvider(this).get(SecondFactsViewModel::class.java)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = arguments?.getString(name)
        binding.textView2.text = arguments?.getString(creator)
        binding.textView3.text = arguments?.getString(description)

        secondFactsViewModel.getRandFact()
        secondFactsViewModel.fact.observe(viewLifecycleOwner) {
            binding.tvRandomFactScreen2.text = it
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}