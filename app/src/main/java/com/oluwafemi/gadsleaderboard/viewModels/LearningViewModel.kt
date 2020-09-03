package com.oluwafemi.gadsleaderboard.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.gadsleaderboard.models.TimeLeaders
import com.oluwafemi.gadsleaderboard.network.LeaderboardAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LearningViewModel(application: Application) : AndroidViewModel(application) {
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _learningLeaders = MutableLiveData<List<TimeLeaders>>()
    val learningLeaders: LiveData<List<TimeLeaders>>
        get() = _learningLeaders

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        learningLeaders.value
        getLearningLeaders()
    }

    private fun getLearningLeaders() {
        viewModelScope.launch {
            val getLeaders = LeaderboardAPI.GadsService.getLearningLeadersAsync()

            try {
                val listResult = getLeaders.await()
                _learningLeaders.value = listResult
                Log.i("LearningNetworkCall", listResult.toString())
            } catch (e: Exception) {
                Log.e("LearningNetworkCall", e.toString())
                _learningLeaders.value = ArrayList()
            }
        }
    }

}