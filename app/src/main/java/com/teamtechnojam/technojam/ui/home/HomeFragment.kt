package com.teamtechnojam.technojam.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamtechnojam.technojam.adapter.TrendingAdapter
import com.teamtechnojam.technojam.databinding.FragmentHomeBinding
import com.teamtechnojam.technojam.model.TrendingModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TrendingAdapter
    private lateinit var list: ArrayList<TrendingModel>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList<TrendingModel>()
        list.add(
            TrendingModel(
                "https://i.ytimg.com/vi/DQ3UfGf87so/maxresdefault.jpg",
                "NASA Space App Challenge",
                "The NASA International Space Apps Challenge " +
                        "is a hackathon for coders, scientists, designers, " +
                        "storytellers, makers, technologists, and innovators around " +
                        "the world to come together and use open data from NASA and its" +
                        " Space Agency Partners to create solutions to challenges we " +
                        "face on Earth and in space.",
                "https://www.spaceappschallenge.org/"
            )
        )

        list.add(
            TrendingModel(
                "https://developers.google.com/open-source/gsoc/resources/downloads/GSoC-Vertical.png",
                "Google Summer Of Code",
                "Are you new to open source and want to learn more about some interesting projects that you can contribute to? Join GSoC where mentors will help guide you on your journey!\n" +
                        "\n" +
                        "It is very important to reach out to the organizations that you are interested in as soon as possible." +
                        " The more conversations you have with the community before you submit your proposal the better your chances of being selected into the GSoC.",
                "https://summerofcode.withgoogle.com/"
            )
        )

        list.add(
            TrendingModel(
                "https://github.blog/wp-content/uploads/2022/10/hacktoberfestbanner.jpeg?fit=1200%2C630",
                "Hactober Fest",
                "Hacktoberfest is an open-source contribution challenge held each year in the month of October. It is a month-long celebration of open source software run by DigitalOcean and DEV.",
                "https://hacktoberfest.com/"
            )
        )

        adapter = TrendingAdapter(requireContext(), list)

        binding.rvTendingList.adapter = adapter

        binding.rvTendingList.apply {
            set3DItem(true)
            setAlpha(true)
            setFadingEdgeLength(10)
        }

        binding.svSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this case
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterTopics(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //Noting to do
            }
        })


    }

    private fun filterTopics(query: String) {
        query?.let { searchText ->
            val filteredList = list.filter { item ->
                item.topicTitle.contains(searchText, ignoreCase = true)
            }
            adapter.filter(filteredList as ArrayList<TrendingModel>)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}