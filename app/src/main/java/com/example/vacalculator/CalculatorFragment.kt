package com.example.vacalculator

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.vacalculator.databinding.FragmentCalculator2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import org.w3c.dom.Text
import java.util.*
import kotlin.math.min

class CalculatorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator2, container, false)
    }

     var firstDate : Date? =null
     var secondDate : Date? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCalculator2Binding.bind(view)
        val dialog = MaterialDialog(requireContext())
            .customView(R.layout.resoult_dialog)
        val countDay : TextView =dialog.findViewById(R.id.viewCount)
//        val caldg = MaterialDialog(requireContext())
//            .customView(R.layout.calendar_dialog)
//        val count: TextView = dialog.findViewById(R.id.viewCount)
//        val days: TextView = dialog.findViewById(R.id.resualtdays)
//        val btnYes: TextView = dialog.findViewById(R.id.btnYes)
//        val btnNo: TextView = dialog.findViewById(R.id.btnNo)
////        val calendardg: TextView = dialog.findViewById(R.id.calendar)




        binding.btnResult.setOnClickListener {
            if (secondDate != null || firstDate != null){
            val diff: Long = secondDate!!.time - firstDate!!.time
            val second = diff / 1000
            val minutes = second / 60
            val hours = minutes / 60
            val days = hours / 24
            countDay.text = days.toString()
            dialog.show()
        }else {
                Toast.makeText(requireContext(), "Выберите дату", Toast.LENGTH_SHORT).show()
            }
        }




        binding.startdate.setOnClickListener {

            val caldg = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.startdate.text = "$dayOfMonth ${month + 1} $year"
                var firstDate = Date(year, month, dayOfMonth)
            },
            Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )
            caldg.show()
        }



        binding.lastDate.setOnClickListener {
            val caldg = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.lastDate.text = "$dayOfMonth ${month + 1} $year"
                var secondDate = Date(year, month, dayOfMonth)
            },
                Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
            caldg.show()
        }
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_calculator2, container, false)
//    }
}