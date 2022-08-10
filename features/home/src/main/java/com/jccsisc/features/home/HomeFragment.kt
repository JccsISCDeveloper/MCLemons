package com.jccsisc.features.home

import androidx.core.content.ContextCompat
import com.boreal.commonutils.base.CUBaseFragment
import com.boreal.commonutils.extensions.hideView
import com.boreal.commonutils.extensions.showView
import com.jccsisc.features.home.constants.ConstantStatus
import com.jccsisc.features.home.databinding.FragmentHomeBinding
import com.jccsisc.features.home.databinding.ItemHistoryMonthBinding
import com.jccsisc.features.home.model.months.MonthsHistory

class HomeFragment : CUBaseFragment<FragmentHomeBinding>() {

    override fun getLayout() = R.layout.fragment_home

    override fun initView() { initElements() }

    fun setImage(binding: ItemHistoryMonthBinding, model: MonthsHistory) = with(binding) {
        when(model.status) {
            ConstantStatus.MONTH_GOOD -> {
                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.green_dark_700))
                imgStatus.setImageResource(R.drawable.ic_good_graphic)
                imgEquals.hideView()
            }
            ConstantStatus.MONTH_EQUALS -> {
                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.yellow_700))
                imgStatus.setImageResource(R.drawable.ic_money_good)
                imgEquals.showView()
            }
            ConstantStatus.MONTH_BAD -> {
                roundableGraphic.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.purple_700))
                imgStatus.setImageResource(R.drawable.ic_bad_graphic)
                imgEquals.hideView()
            }
        }
    }
}