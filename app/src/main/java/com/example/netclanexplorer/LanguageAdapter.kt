package com.example.searchviewkotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanexplorer.LanguageData
import com.example.netclanexplorer.R

class LanguageAdapter(var mList: List<LanguageData>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgprofile : ImageView = itemView.findViewById(R.id.profile)
        val name : TextView = itemView.findViewById(R.id.u_name)
        val invite : TextView = itemView.findViewById(R.id.invite)
        val address : TextView = itemView.findViewById(R.id.u_address)
        val distance : TextView = itemView.findViewById(R.id.u_distanace)
        val hobbies : TextView = itemView.findViewById(R.id.u_hobbies)
        val desc : TextView = itemView.findViewById(R.id.u_desc)

    }

    fun setFilteredList(mList: List<LanguageData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        Log.d("onbindviewholder ",mList.toString())

        holder.imgprofile.setImageResource(mList[position].imgprofile)
        holder.name.text = mList[position].name
        holder.address.text = mList[position].address
        holder.invite.text = mList[position].invite
        holder.distance.text = mList[position].distance
        holder.hobbies.text = mList[position].hobbies
        holder.desc.text = mList[position].desc
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
