package com.jo.trudoctask.details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jo.trudoctask.R
import com.jo.trudoctask.list.domain.model.Business
import kotlinx.android.synthetic.main.fragment_business_details.*


/**
 * A simple [Fragment] subclass.
 */
class BusinessDetailsFragment : Fragment() {

    private lateinit var argsBusiness: Business
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        argsBusiness = requireArguments().getParcelable<Business>("argsBusiness")!!
        return inflater.inflate(R.layout.fragment_business_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvTest.text = "${argsBusiness.name}\n${argsBusiness.id}"
        super.onViewCreated(view, savedInstanceState)
    }
}