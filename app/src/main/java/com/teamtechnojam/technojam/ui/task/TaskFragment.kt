package com.teamtechnojam.technojam.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamtechnojam.technojam.adapter.YourTaskAdapter
import com.teamtechnojam.technojam.databinding.FragmentTaskBinding
import com.teamtechnojam.technojam.model.YourTaskModel

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val taskViewModel =
            ViewModelProvider(this).get(TaskViewModel::class.java)

        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTask = ArrayList<YourTaskModel>()

        listTask.add(YourTaskModel("Web Poster Design", "Team Lead"))
        listTask.add(YourTaskModel("Android Application Update", "Android Lead"))
        listTask.add(YourTaskModel("Web Application Update", "Web Dev Lead"))
        listTask.add(YourTaskModel("Flutter Application UI", "Android Lead"))
        listTask.add(YourTaskModel("API Integrating", "Team Lead"))
        listTask.add(YourTaskModel("Web Application API", "Web Dev Lead"))

        val adapter = YourTaskAdapter(requireContext(), listTask)

        binding.rvYourTask.layoutManager = LinearLayoutManager(requireContext())
        binding.rvYourTask.adapter = adapter

        binding.btnBack.setOnClickListener {

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}