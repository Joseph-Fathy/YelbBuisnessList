package com.jo.trudoctask.details.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jo.trudoctask.R
import com.jo.trudoctask.databinding.FragmentBusinessDetailsBinding
import com.jo.trudoctask.details.presentation.view_model.BusinessDetailsViewModel
import com.jo.trudoctask.list.domain.model.Business
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class BusinessDetailsFragment : Fragment() {

    private lateinit var argsBusiness: Business
    private val businessDetailsViewModel: BusinessDetailsViewModel by viewModels()
    lateinit var binding: FragmentBusinessDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_business_details,
                container, false)
        binding.apply {
            lifecycleOwner = this@BusinessDetailsFragment
            viewModel = businessDetailsViewModel
        }
        argsBusiness = requireArguments().getParcelable<Business>("argsBusiness")!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        argsBusiness.id?.let { businessDetailsViewModel.getBusinessDetails(it) }
    }
}