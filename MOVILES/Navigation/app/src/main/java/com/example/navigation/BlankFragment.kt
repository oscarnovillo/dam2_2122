package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.BlankFragmentBinding
import com.example.navigation.databinding.FragmentBlankBinding
import java.time.LocalDate

class BlankFragment : Fragment() {


    private var _binding : FragmentBlankBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener{
            val action = BlankFragmentDirections.actionBlankFragmentToBlankFragment22(Persona(1,"mmm"))
            findNavController().navigate(action)

        }

    }
}