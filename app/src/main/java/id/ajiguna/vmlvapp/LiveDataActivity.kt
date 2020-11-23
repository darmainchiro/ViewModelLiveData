package id.ajiguna.vmlvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ajiguna.vmlvapp.model.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getDetik().observe(this, Observer {
            tv_waktu.text = it.toString()
        })
        viewModel.selesai.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Selesai",

                    Toast.LENGTH_SHORT).show()

            }
        })
        btn_mulai.setOnClickListener{
            if(et_waktu.text.isEmpty() ||

                et_waktu.text.toString()=="0"){

                Toast.makeText(this, "Invalid Number",

                    Toast.LENGTH_SHORT).show()
            }else {
                viewModel.waktu.value =
                    et_waktu.text.toString().toLong()
                viewModel.startTimer()
            }
        }
        btn_berhenti.setOnClickListener {
            viewModel.stopTimer()
        }
        btn_reset.setOnClickListener {
            viewModel.stopTimer()
            tv_waktu.text = "0"
        }
    }
}