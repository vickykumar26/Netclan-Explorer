package com.example.netclanexplorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchviewkotlin.LanguageAdapter
import java.util.Locale


class Personal_Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_2, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        addDataToList()

        return view
    }


    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(LanguageData(R.drawable.profile_img,"Vicky Kumar","+ INVITE","Mohali | Android Developer","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Puja Dutt","+ INVITE","Delhi | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Shalvi Gupta","+ INVITE","Shahjahanpur | Android Developer","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Shreya Srivastava","+ INVITE","Shahjahanpur | Android Developer","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Yukti Gupta","+ INVITE","Agra | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Sourav Kumar","+ INVITE","Mohali | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Reuel Masih","+ INVITE","Kharar | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Keshav Singh","+ INVITE","Chandigarh | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Ashutosh Thakur","+ INVITE","Chandigarh | Content Writer","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Anuj Bhardwaj","+ INVITE","Delhi | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Mukul Sharma","+ INVITE","Hamirpur | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))
        mList.add(LanguageData(R.drawable.profile_img,"Ayush Kumar","+ INVITE","Chandigarh | Student","Within 100-200 m","Coffee | Business | Friendship","Hi community! I am open to new Connections."))

    }


}





