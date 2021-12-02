package com.example.navigation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.onNavDestinationSelected
import com.example.navigation.databinding.BlankFragmentBinding
import com.example.navigation.databinding.FragmentBlankBinding

class BlankFragment2 : Fragment() {

    private var _binding : BlankFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  BlankFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : BlankFragment2Args by navArgs()
        binding.texto.setText(args.persona?.nombre ?: "nulo")

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_dos, menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.nuevo -> {
                // Handle favorite icon press
                //menuItem.onNavDestinationSelected(navController)
                //findNavController().navigate(R.id.action_blankFragment_to_blankFragment22)

                //findNavController().navigate()

                Toast.makeText(context,"kkkk", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nuevo2 -> {
                //menuItem.onNavDestinationSelected(navController)
                // Handle search icon press
                true
            }
            else -> false
        }


}