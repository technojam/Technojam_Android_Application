package com.teamtechnojam.technojam.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.teamtechnojam.technojam.AboutActivity
import com.teamtechnojam.technojam.OurAchievementsActivity
import com.teamtechnojam.technojam.OurTeamActivity
import com.teamtechnojam.technojam.PermissionsActivity
import com.teamtechnojam.technojam.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rlAchievements.setOnClickListener {
            startActivity(Intent(requireContext(), OurAchievementsActivity::class.java))
        }

        binding.rlPermissions.setOnClickListener {
            startActivity(Intent(requireContext(), PermissionsActivity::class.java))
        }

        binding.rlOurTeam.setOnClickListener {
            startActivity(Intent(requireContext(), OurTeamActivity::class.java))
        }

        binding.rlAboutUs.setOnClickListener {
            startActivity(Intent(requireContext(), AboutActivity::class.java))
        }

        binding.btnBack.setOnClickListener {

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}