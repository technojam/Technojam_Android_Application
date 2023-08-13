package com.teamtechnojam.technojam.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.teamtechnojam.technojam.adapter.EventsAdapter
import com.teamtechnojam.technojam.databinding.FragmentEventsBinding
import com.teamtechnojam.technojam.model.EventsModel

class EventsFragment : Fragment() {

    private var _binding: FragmentEventsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this)[EventsViewModel::class.java]

        _binding = FragmentEventsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<EventsModel>()
        list.add(
            EventsModel(
                "Web Development Workshop",
                "Sun Aug 12 2023",
                "Two day workshop on web development"
            )
        )

        list.add(
            EventsModel(
                "App Development using Flutter",
                "Sun May 12 2023",
                "a day long workshop on application development"
            )
        )

        list.add(
            EventsModel(
                "Java Programming and DSA",
                "Tue Aug 20 2023",
                "Month long DSA course for placements"
            )
        )

        val adapter = EventsAdapter(requireContext(), list)


        binding.rvEventsList.adapter = adapter
        binding.rvEventsList.apply {
            set3DItem(true)
            setAlpha(true)
            setInfinite(false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}