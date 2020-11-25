package com.jo.trudoctask.list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jo.trudoctask.R
import com.jo.trudoctask.databinding.FragmentBusinessListBinding
import com.jo.trudoctask.list.presentation.view_model.BusinessListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.business_error_view.*
import kotlinx.android.synthetic.main.fragment_business_list.*

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class BusinessListFragment : Fragment() {

    private val businessListViewModel: BusinessListViewModel by viewModels()
    lateinit var binding: FragmentBusinessListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_business_list,
            container, false
        )
        binding.apply {
            lifecycleOwner = this@BusinessListFragment
            viewModel = businessListViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        rvBusinessesList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = BusinessListRecyclerViewAdapter(mutableListOf()) {
                Toast.makeText(activity, it.name, Toast.LENGTH_LONG).show()
            }
        }
        businessListViewModel.getBusinessList(0)
    }

}