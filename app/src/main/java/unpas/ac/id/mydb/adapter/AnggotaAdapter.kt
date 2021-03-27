package unpas.ac.id.mydb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import unpas.ac.id.mydb.data.Anggota
import unpas.ac.id.mydb.databinding.ItemsAnggotaBinding

class AnggotaAdapter(val data:List<Anggota?>?,val context: Context):RecyclerView.Adapter<AnggotaAdapter.AnggotaHolder>() {
    class AnggotaHolder(var binding: ItemsAnggotaBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(anggota: Anggota?,context: Context){
            binding.itemsId.text = anggota?.id.toString()
            binding.itemsNama.text = anggota?.nama
            binding.itemsUmur.text = anggota?.umur
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnggotaHolder {
        var binding = ItemsAnggotaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnggotaHolder(binding)
    }

    override fun onBindViewHolder(holder: AnggotaHolder, position: Int) {
        holder.bind(data?.get(position),context)
    }

    override fun getItemCount()=data?.size ?:0
}