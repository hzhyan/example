package com.example.myapplication.viewtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.LayoutViewTestBinding

class ViewTestActivity: AppCompatActivity() {

    private val binding by lazy {
        LayoutViewTestBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.renderBtn.setOnClickListener {
            binding.recyclerView.requestLayout()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CusAdapter()
    }

}

class CusAdapter : RecyclerView.Adapter<CusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CusViewHolder {
        return CusViewHolder(CustomTextView(parent.context).apply {
            setPadding(30)
        })
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(holder: CusViewHolder, position: Int) {
        Log.d("yanshuang", "onBindViewHolder $position")
        holder.textView.text = "这是第$position 个Item 啊哈哈哈"
        holder.textView.index = position

        holder.textView.setOnClickListener {
            it.requestLayout()
        }
    }

}

class CusViewHolder(val textView: CustomTextView): ViewHolder(textView)
