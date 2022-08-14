package com.jccsisc.features.home

import android.widget.ArrayAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import com.boreal.commonutils.extensions.setOnSingleClickListener
import com.boreal.commonutils.utils.GAdapter
import com.jccsisc.features.home.databinding.ItemEmployeeWorkingBinding
import com.jccsisc.features.home.databinding.ItemHistoryMonthBinding
import com.jccsisc.features.home.model.employee.Employees
import com.jccsisc.features.home.model.months.MonthsHistory

/**
 * Project: MCLemons
 * FROM: com.jccsisc.features.home
 * Created by Julio Cesar Camacho Silva on 08/08/22
 */
fun HomeFragment.initElements() = with(binding) {

    val adapterEmployees by lazy {
        GAdapter<ItemEmployeeWorkingBinding, Employees>(
            R.layout.item_employee_working,
            AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<Employees>() {
                override fun areItemsTheSame(oldItem: Employees, newItem: Employees) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Employees, newItem: Employees) =
                    oldItem == newItem
            }).build(),
            holderCallback = { itemBinding, model, list, adapter, position ->
                itemBinding.apply {
                    tvName.text = getString(R.string.str_name, model.name, model.lastName)

                    tvRating.text = model.position.toString()
                    tvNameRating.text = "Lugar" //todo hacero con remote config
                    tvPayDay.text = (30 * model.numBox).toString()

                    tvBoxesDay.text = if (model.numBox > 1) {
                        getString(R.string.str_boxes, model.numBox.toString())
                    } else {
                        getString(R.string.str_box, model.numBox.toString())
                    }

                    itemBinding.root.setOnSingleClickListener {

                    }
                }
            }
        )
    }

    val adapterMonths by lazy {
        GAdapter<ItemHistoryMonthBinding, MonthsHistory>(
            R.layout.item_history_month,
            AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<MonthsHistory>() {
                override fun areItemsTheSame(oldItem: MonthsHistory, newItem: MonthsHistory) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: MonthsHistory, newItem: MonthsHistory) =
                    oldItem == newItem
            }).build(),
            holderCallback = { itemBinding, model, list, adapter, position ->
                itemBinding.apply {

                    setImage(itemBinding, model)

                    tvMonth.text = getString(R.string.str_month_year, model.name, model.year)
                    tvQuantityCaj.text = getString(R.string.str_month_boxes, model.quantityBox.toString())
                    tvPayMain.text = getString(R.string.str_month_money, model.money.toString())

                    itemBinding.root.setOnSingleClickListener {

                    }
                }
            }
        )
    }

    tvPayable.text = "1,170"
    tvPriceBox.text = "30"
    tvCurrentMonthBoxes.text = "39"
    tvAmountPaid.text = "$0.00"
    tvMonth.text = "Ago"

    listEmployees.add(Employees(1, "Julio Cesar", "Camacho Silva", "", 1, 16))
    listEmployees.add(Employees(2, "Juan", "Alcantar Reynosa", "", 2, 10))
    listEmployees.add(Employees(3, "Oscar", "Orozco Flores", "", 3, 7))
    listEmployees.add(Employees(4, "Luis Alfredo", "Martinez Martinez", "", 4, 5))
    listEmployees.add(Employees(5, "José Luis", "Gonzalez Carmona", "", 5, 1))

    rvEmployees.adapter = adapterEmployees
    adapterEmployees.submitList(listEmployees)


    listMonths.add(MonthsHistory(1, "Julio", 45000, 1500, "2021", 0))
    listMonths.add(MonthsHistory(2, "Junio", 30000, 1000, "2021", 1))
    listMonths.add(MonthsHistory(3, "Mayo", 31050, 1035, "2021", 2))
    listMonths.add(MonthsHistory(4, "Abril", 31050, 1035, "2021", 1))
    listMonths.add(MonthsHistory(5, "Marzo", 45000, 1500, "2021", 0))
    listMonths.add(MonthsHistory(6, "Febrero", 45000, 1500, "2021", 0))
    listMonths.add(MonthsHistory(7, "Enero", 45000, 1500, "2021", 0))

    rvHistoryMonth.adapter = adapterMonths
    adapterMonths.submitList(listMonths)

    val years = arrayListOf("2022", "2021")
    val adapterYears = ArrayAdapter(requireContext(), R.layout.item_year, years)
    autoCompleteYear.setAdapter(adapterYears)
    autoCompleteYear.onItemClickListener = this@initElements


}

