package com.example.kitsuapi.ui.fragments.main

import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFlowFragment

class MainFlowFragment : BaseFlowFragment(R.layout.fragment_main_flow) {

    override val navigationId: Int
        get() = R.id.main_nav_host_container
}