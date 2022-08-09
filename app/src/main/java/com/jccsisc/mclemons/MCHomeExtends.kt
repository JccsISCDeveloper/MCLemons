package com.jccsisc.mclemons

import androidx.navigation.findNavController
import com.jccsisc.mclemons.core.utils.GlobalLambdas.navigateLoginToHome

/**
 * Project: MCLemons
 * FROM: com.jccsisc.mclemons
 * Created by Julio Cesar Camacho Silva on 08/08/22
 */
fun MCHomeActivity.initElements() = with(binding) {


    navigateLoginToHome = { findNavController(R.id.nav_hot_fragment).navigate(R.id.homeFragment) }
}