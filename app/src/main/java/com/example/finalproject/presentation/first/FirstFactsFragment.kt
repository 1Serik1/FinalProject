package com.example.finalproject.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.R
import com.example.finalproject.data.local.FactsDataClass
import com.example.finalproject.databinding.FragmentFirstBinding
import com.example.finalproject.presentation.second.SecondFactsFragment

class FirstFactsFragment : Fragment(), FirstFactsAdapter.Listener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: FirstFactsAdapter
    lateinit var firstFactsViewModel: FirstFactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = FirstFactsAdapter(this)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        firstFactsViewModel = ViewModelProvider(this).get(FirstFactsViewModel::class.java)

        firstFactsViewModel.getCard()
        firstFactsViewModel.cardCollect.observe(viewLifecycleOwner) {
            adapter.setListOfFacts(it)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.Rv.layoutManager = layoutManager
        binding.Rv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(card: FactsDataClass) {
        val bundle = bundleOf(
            SecondFactsFragment.name to card.numberOfFacts,
            SecondFactsFragment.creator to card.shortDescCard,
            SecondFactsFragment.description to card.screen2,
        )
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }
}


