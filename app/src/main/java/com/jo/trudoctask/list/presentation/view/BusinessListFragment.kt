package com.jo.trudoctask.list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jo.trudoctask.R
import com.jo.trudoctask.databinding.FragmentBusinessListBinding
import com.jo.trudoctask.list.presentation.binding.setBusinessListViewState
import com.jo.trudoctask.list.presentation.view_model.BusinessListViewModel
import com.jo.trudoctask.list.presentation.view_state.BusinessListViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.business_error_view.*
import kotlinx.android.synthetic.main.fragment_business_list.*

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class BusinessListFragment : Fragment() {

    private val viewModel: BusinessListViewModel by viewModels()
    lateinit var binding: FragmentBusinessListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_business_list,
            container, false
        )
        binding.lifecycleOwner = this@BusinessListFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.viewStateLiveData.observe(viewLifecycleOwner, {
            handle(it)
        })
        viewModel.getBusinessList(0)
    }

    private fun handle(viewState: BusinessListViewState) {
        pbLoadingBusinessesList.visibility = if (viewState.isLoading) View.VISIBLE else View.GONE
        businessesListEmptyContainer.visibility = if (viewState.isEmpty) View.VISIBLE else View.GONE
        if (viewState.error != null) {
            businessesListErrorContainer.visibility = View.VISIBLE
            tvErrorMessage.text = viewState.error!!.message
        } else
            View.GONE
        if (viewState.data != null && viewState.data!!.isNotEmpty())
            rvBusinessesList.setBusinessListViewState(viewState)

    }
}