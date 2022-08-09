package com.jccsisc.mclemons

import com.boreal.commonutils.base.CUBaseActivity
import com.jccsisc.mclemons.databinding.McHomeActivityBinding

class MCHomeActivity : CUBaseActivity<McHomeActivityBinding>() {

    override fun getLayout() = R.layout.mc_home_activity

    override fun initView() { initElements() }

}