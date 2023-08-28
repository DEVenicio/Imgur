package com.venicio.imgur.view.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.venicio.imgur.R
import com.venicio.imgur.data.model.Image
import com.venicio.imgur.databinding.ItemImageBinding

class ImgurAdapter : ListAdapter<Image, ImgurAdapter.ImgurVH>(ImgurDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgurVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(inflater, parent, false)

        return ImgurVH(binding)
    }

    override fun onBindViewHolder(holder: ImgurVH, position: Int) {
        holder.bindImgur(getItem(position))
    }


    inner class ImgurVH(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindImgur(dataImage: Image) {
            Glide
                .with(binding.ivImageItem)
                .load(dataImage.link)
                .placeholder(R.color.gray)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.GONE
                        return false
                    }
                })
                .error(R.drawable.not_load_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivImageItem)
        }
    }

}


class ImgurDiffUtil : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.link == newItem.link
    }

}