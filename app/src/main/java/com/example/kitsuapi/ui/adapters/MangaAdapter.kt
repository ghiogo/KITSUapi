package com.example.kitsuapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.base.BaseDiffUtilItemCallback
import com.example.kitsuapi.databinding.ItemKitsuBinding
import com.example.kitsuapi.models.DataItem

class MangaAdapter :
    PagingDataAdapter<DataItem, MangaAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    inner class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DataItem) {
            binding.tvKitsu.text = item.attributes.titles.enJp
            Glide.with(binding.imageKitsu).load(item.attributes.posterImage.original)
                .into(binding.imageKitsu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter.ViewHolder {
        return ViewHolder(
            ItemKitsuBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}