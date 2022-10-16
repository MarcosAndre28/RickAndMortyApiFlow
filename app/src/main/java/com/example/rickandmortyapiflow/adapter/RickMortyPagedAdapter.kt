package com.example.rickandmortyapiflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapiflow.adapter.RickMortyPagedAdapter.*
import com.example.rickandmortyapiflow.databinding.RickMortyLayoutBinding
import com.example.rickandmortyapiflow.model.RickMorty

/*PagingDataAdapter : Este é o principal componente de interface do usuário responsável por
apresentar os dados no RecyclerView. Ele consome o PagingData como o tipo de entrada e escuta
seus eventos de carregamento internos. Ele carrega dados após granulação fina usando DiffUtil
em um thread em segundo plano, portanto, não espere soluços ao adicionar novos itens no thread
da interface do usuário.*/

/*DiffUtil: Essa classe encontra a diferença entre duas listas e fornece a lista atualizada como
saída. Essa classe é usada para notificar atualizações para um Adaptador RecyclerView.*/

class RickMortyPagedAdapter : PagingDataAdapter<RickMorty, MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: RickMortyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        // O método getItem() é do PagingDataAdapter

        holder.binding.apply {
            textView.text = "${currentItem?.name}"
            val imageLink = currentItem?.image

            // Aqui estou usando coroutine image loader(coil) para exibir imagens
            // vc pode usar o  glide
            imageView.load(imageLink) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RickMortyLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}