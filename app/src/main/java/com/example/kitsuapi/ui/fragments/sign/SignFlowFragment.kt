package com.example.kitsuapi.ui.fragments.sign

import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFlowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignFlowFragment : BaseFlowFragment(R.layout.fragment_sign_flow) {

    override val navigationId: Int
        get() = R.id.sign_nav_host_container
}