package com.example.vacalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.vacalculator.databinding.FragmentCalculator2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import org.w3c.dom.Text

class CalculatorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCalculator2Binding.bind(view)
        val dialog = MaterialDialog(requireContext())
            .customView(R.layout.resoult_dialog)
        val caldg = MaterialDialog(requireContext())
            .customView(R.layout.calendar_dialog)
        val count: TextView = dialog.findViewById(R.id.viewCount)
        val days: TextView = dialog.findViewById(R.id.resualtdays)
        val btnYes: TextView = dialog.findViewById(R.id.btnYes)
        val btnNo: TextView = dialog.findViewById(R.id.btnNo)
        val calendardg: TextView = dialog.findViewById(R.id.calendar)


        binding.btnResult.setOnClickListener {

            dialog.show()
        }




        binding.startdate.setOnClickListener {
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