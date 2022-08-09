package com.jccsisc.mclemons.login

import com.jccsisc.mclemons.core.utils.GlobalLambdas.navigateLoginToHome

/**
 * Project: MCLemons
 * FROM: com.jccsisc.mclemons.login
 * Created by Julio Cesar Camacho Silva on 08/08/22
 */
fun LoginFragment.initElements() = with(binding) {

    btnLogin.setOnClickListener { navigateLoginToHome() }
}