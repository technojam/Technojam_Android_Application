package com.teamtechnojam.technojam

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtechnojam.technojam.adapter.MembersAdapter
import com.teamtechnojam.technojam.databinding.ActivityOurTeamBinding
import com.teamtechnojam.technojam.model.MembersModel
import com.teamtechnojam.technojam.model.TrendingModel

class OurTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOurTeamBinding
    private lateinit var membersList: ArrayList<MembersModel>
    private lateinit var adapter:MembersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOurTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        getDataInList()

        adapter = MembersAdapter(this@OurTeamActivity, membersList)
        binding.rvMembersList.layoutManager =
            GridLayoutManager(this@OurTeamActivity, 2, GridLayoutManager.VERTICAL, false)
        binding.rvMembersList.adapter = adapter

        binding.svSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this case
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterMembers(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //Noting to do
            }
        })

    }

    private fun getDataInList() {
        membersList = ArrayList()
        membersList.add(
            MembersModel(
                "https://static.vecteezy.com/system/resources/previews/002/002/427/original/man-avatar-character-isolated-icon-free-vector.jpg",
                "Team Member 1", "Team Lead"
            )
        )

        membersList.add(
            MembersModel(
                "https://img.freepik.com/premium-vector/person-avatar-design_24877-38130.jpg",
                "Team Member 2", "Team Lead"
            )
        )
        membersList.add(
            MembersModel(
                "https://static.vecteezy.com/system/resources/previews/002/002/257/original/beautiful-woman-avatar-character-icon-free-vector.jpg",
                "Team Member 3", "Senior Member"
            )
        )
        membersList.add(
            MembersModel(
                "https://static.vecteezy.com/system/resources/previews/002/002/427/original/man-avatar-character-isolated-icon-free-vector.jpg",
                "Team Member 4", "Team Member"
            )
        )

        membersList.add(
            MembersModel(
                "https://img.freepik.com/premium-vector/person-avatar-design_24877-38130.jpg",
                "Team Member 5", "Team Member"
            )
        )
        membersList.add(
            MembersModel(
                "https://static.vecteezy.com/system/resources/previews/002/002/257/original/beautiful-woman-avatar-character-icon-free-vector.jpg",
                "Team Member 6", "Team Member"
            )
        )

    }
    private fun filterMembers(query: String) {
        query.let { searchText ->
            val filteredList = membersList.filter { item ->
                item.memberName.contains(searchText, ignoreCase = true)
            }
            adapter.filter(filteredList as ArrayList<MembersModel>)
        }
    }
}