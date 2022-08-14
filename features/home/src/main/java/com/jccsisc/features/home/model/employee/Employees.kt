package com.jccsisc.features.home.model.employee

/**
 * Project: MCLemons
 * FROM: com.jccsisc.features.home.model
 * Created by Julio Cesar Camacho Silva on 10/08/22
 */
data class Employees(
    val id: Long,
    val name: String,
    val lastName: String,
    val image: String,
    val position: Int,
    val numBox: Int
)
