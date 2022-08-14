package com.jccsisc.features.home

import android.view.View
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import com.boreal.commonutils.base.CUBaseFragment
import com.boreal.commonutils.extensions.hideView
import com.boreal.commonutils.extensions.showToast
import com.boreal.commonutils.extensions.showView
import com.boreal.commonutils.utils.GAdapter
import com.jccsisc.features.home.constants.ConstantStatus
import com.jccsisc.features.home.databinding.FragmentHomeBinding
import com.jccsisc.features.home.databinding.ItemEmployeeWorkingBinding
import com.jccsisc.features.home.databinding.ItemHistoryMonthBinding
import com.jccsisc.features.home.model.employee.Employees
import com.jccsisc.features.home.model.months.MonthsHistory

class HomeFragment : CUBaseFragment<FragmentHomeBinding>(), AdapterView.OnItemClickListener {

    val listEmployees = arrayListOf<Employees>()
    var listMonths = arrayListOf<MonthsHistory>()

    override fun getLayout() = R.layout.fragment_home

    override fun initView() { initElements() }

    fun setImage(binding: ItemHistoryMonthBinding, model: MonthsHistory) = with(binding) {
        when(model.status) {
            ConstantStatus.MONTH_GOOD -> {
//                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.green_dark_700))
                roundableGraphic.strokeLineColor = ContextCompat.getColor(binding.root.context, R.color.green_dark_700)
                imvStatus.setImageResource(R.drawable.ic_good_graphic)
                imvEquals.hideView()
            }
            ConstantStatus.MONTH_EQUALS -> {
//                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.yellow_700))
                roundableGraphic.strokeLineColor = ContextCompat.getColor(binding.root.context, R.color.yellow_700)
                imvStatus.setImageResource(R.drawable.ic_money_good)
                imvEquals.showView()
            }
            ConstantStatus.MONTH_BAD -> {
//                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.purple_700))
                roundableGraphic.strokeLineColor = ContextCompat.getColor(binding.root.context, R.color.purple_700)
                imvStatus.setImageResource(R.drawable.ic_bad_graphic)
                imvEquals.hideView()
            }
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, idItem: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        showToast(item)
    }
}