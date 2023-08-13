package com.teamtechnojam.technojam.ui.events

import androidx.lifecycle.ViewModel
import com.teamtechnojam.technojam.model.EventsModel

class EventsViewModel : ViewModel() {
    private val _dummyList = mutableListOf<EventsModel>()
    val dummyList get() = _dummyList


}