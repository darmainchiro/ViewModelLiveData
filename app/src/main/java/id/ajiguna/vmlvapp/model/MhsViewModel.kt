package id.ajiguna.vmlvapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MhsViewModel : ViewModel() {
    private var listOfMhs: MutableLiveData<List<Mahasiswa>>? = null
    fun getMhs(): LiveData<List<Mahasiswa>> {
        if (listOfMhs == null) {
            listOfMhs = MutableLiveData()
        }
        return listOfMhs as MutableLiveData<List<Mahasiswa>>
    }

    fun tambahMhs(name: String, nim: String, kelas: String){
        val mhsList = ArrayList<Mahasiswa>()
        mhsList.add(Mahasiswa(name,nim,kelas))
        listOfMhs!!.postValue(mhsList)
    }
}