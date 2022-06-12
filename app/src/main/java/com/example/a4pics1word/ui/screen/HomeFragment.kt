package com.example.a4pics1word.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a4pics1word.R
import com.example.a4pics1word.databinding.FragmentHomeBinding
import com.example.a4pics1word.ui.viewmodel.HomeViewModel
import com.example.a4pics1word.util.showSnackBar

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.stateLiveData.observe(this, stateObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getState()

    }

    //---------- Observers -----------//

    private val stateObserver = Observer<List<Boolean>> {

        binding.constraintLayout.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToPlaygroundFragment(
                    "Newbie"
                )
            )
        }

        if (it[0]) {
            binding.stateLevel2ImgBtn.setBackgroundResource(R.drawable.ic_play)
            binding.constraintLayout2.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPlaygroundFragment(
                        "Middle"
                    )
                )
            }
        } else {
            binding.stateLevel2ImgBtn.setBackgroundResource(R.drawable.ic_lock)
            binding.constraintLayout2.setOnClickListener {
                showSnackBar("This mode is locked")
            }

        }

        if (it[0]) {
            binding.stateLevel3ImgBtn.setBackgroundResource(R.drawable.ic_play)
            binding.constraintLayout2.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPlaygroundFragment(
                        "Expert"
                    )
                )
            }
        } else {
            binding.stateLevel3ImgBtn.setBackgroundResource(R.drawable.ic_lock)
            binding.constraintLayout3.setOnClickListener {
                showSnackBar("This mode is locked")
            }

        }
    }

}