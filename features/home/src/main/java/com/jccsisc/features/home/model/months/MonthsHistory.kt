package com.jccsisc.features.home.model.months

import java.net.IDN

/**
 * Project: MCLemons
 * FROM: com.jccsisc.features.home.model.months
 * Created by Julio Cesar Camacho Silva on 10/08/22
 */
data class MonthsHistory(
    val id: Int,
    val name: String,
    val money: Long,
    val quantityBox: Long,
    val year: String,
    val status: Int
)
