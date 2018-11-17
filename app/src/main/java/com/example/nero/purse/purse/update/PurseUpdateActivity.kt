package com.example.nero.purse.purse.update

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import com.example.nero.purse.R
import com.example.nero.purse.database.purse.Purse
import com.example.nero.purse.database.purse.PurseViewModel
import com.example.nero.purse.databinding.ActivityPurseUpdateBinding
import com.example.nero.purse.purse.PurseActivity
import kotlinx.android.synthetic.main.activity_purse_create.*

class PurseUpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPurseUpdateBinding = DataBindingUtil.setContentView(this, R.layout.activity_purse_update)
        val extraPurse: Purse = intent.getParcelableExtra("purse")
        binding.purse = extraPurse

        setSpinnerDefaultValue(extraPurse.purseType)

        spn_type_purse?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                iv_purse_image.setImageResource(R.drawable.ic_ukraine)
            }

            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, index: Int, p3: Long) {
                when (index) {
                    0 -> iv_purse_image.setImageResource(R.drawable.ic_ukraine)
                    1 -> iv_purse_image.setImageResource(R.drawable.ic_united_states)
                    2 -> iv_purse_image.setImageResource(R.drawable.ic_european_union)
                }
            }
        }

        btn_ok.setOnClickListener {
            val updatedPurse = Purse(
                    purseId = extraPurse.purseId,
                    purseName = edt_name_purse.text.toString(),
                    purseValue = edt_value_purse.text.toString().toDouble(),
                    purseType = spn_type_purse.selectedItem.toString()
            )

            val purseViewModel: PurseViewModel = ViewModelProviders.of(this).get(
                    PurseViewModel::class.java
            )
            purseViewModel.update(updatedPurse)
            startActivity(Intent(this, PurseActivity::class.java))
        }

        btn_cancel.setOnClickListener {
            startActivity(Intent(this, PurseActivity::class.java))
        }
    }

    private fun setSpinnerDefaultValue(value: String?) {
        when (value) {
            "UAH" -> spn_type_purse?.setSelection(0)
            "USD" -> spn_type_purse?.setSelection(1)
            "EUR" -> spn_type_purse?.setSelection(2)
        }
    }
}
