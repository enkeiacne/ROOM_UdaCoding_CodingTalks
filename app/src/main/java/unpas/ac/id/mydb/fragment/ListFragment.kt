package unpas.ac.id.mydb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import unpas.ac.id.mydb.R
import unpas.ac.id.mydb.adapter.AnggotaAdapter
import unpas.ac.id.mydb.data.Anggota
import unpas.ac.id.mydb.databinding.FragmentListBinding
import unpas.ac.id.mydb.viewModel.AnggotaViewModel


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var anggotaViewModel: AnggotaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.bind(view)
        anggotaViewModel = ViewModelProvider(this).get(AnggotaViewModel::class.java)
        anggotaViewModel.readData.observe(viewLifecycleOwner,{anggota->
            showData(anggota)
        })

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

    private fun showData(anggota: List<Anggota>?) {
        binding.listAnggota.adapter = AnggotaAdapter(anggota,requireContext())
    }


}