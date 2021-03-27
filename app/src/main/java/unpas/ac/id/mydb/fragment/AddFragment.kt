package unpas.ac.id.mydb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import unpas.ac.id.mydb.R
import unpas.ac.id.mydb.data.Anggota
import unpas.ac.id.mydb.databinding.FragmentAddBinding
import unpas.ac.id.mydb.viewModel.AnggotaViewModel


class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    lateinit var anggotaViewModel: AnggotaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        binding = FragmentAddBinding.bind(view)
        anggotaViewModel = ViewModelProvider(this).get(AnggotaViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            var dataNama = binding.inputNama.text
            var dataUmur = binding.inputUmur.text
            var anggota=Anggota(0,dataNama.toString(),dataUmur.toString())
            anggotaViewModel.insertData(anggota)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return view
    }

}