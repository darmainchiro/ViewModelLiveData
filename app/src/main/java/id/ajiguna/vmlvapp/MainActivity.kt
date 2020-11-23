package id.ajiguna.vmlvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.ajiguna.vmlvapp.adapter.MhsAdapter
import id.ajiguna.vmlvapp.model.Mahasiswa
import id.ajiguna.vmlvapp.model.MhsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data= MutableLiveData<List<Mahasiswa>>()
    lateinit  var mhsData:List<Mahasiswa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_mhs.layoutManager = LinearLayoutManager(this)
        val model = ViewModelProviders.of(this).get(MhsViewModel::class.java)
        model.getMhs().observe(this, Observer<List<Mahasiswa>>{ mhs ->
            data.value=mhs
            mhsData=mhs!!
            rv_mhs.adapter=MhsAdapter(data)
        })

        btn_simpan.setOnClickListener {
            val name = et_name.text.toString().trim()
            val nim = et_nim.text.toString().trim()
            val kelas = et_kelas.text.toString().trim()

            model.tambahMhs(name, nim, kelas)
        }
    }

}