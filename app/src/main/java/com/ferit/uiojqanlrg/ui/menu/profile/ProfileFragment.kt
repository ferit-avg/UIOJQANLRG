package com.ferit.uiojqanlrg.ui.menu.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ferit.uiojqanlrg.R
import com.ferit.uiojqanlrg.databinding.FragmentProfileBinding
import com.ferit.uiojqanlrg.ui.base.BaseFragment

class ProfileFragment: BaseFragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}