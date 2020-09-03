package com.oluwafemi.gadsleaderboard.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.gadsleaderboard.models.SkillLeaders
import com.oluwafemi.gadsleaderboard.network.LeaderboardAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class SkillViewModel (application: Application) : AndroidViewModel (application) {
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _skillLeaders = MutableLiveData<List<SkillLeaders>>()
    val skillLeaders: LiveData<List<SkillLeaders>>
        get() = _skillLeaders

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        skillLeaders.value
        getSkillLeaders()
    }

    private fun getSkillLeaders() {
        viewModelScope.launch {
            val getLeaders = LeaderboardAPI.GadsService.getSkillLeadersAsync()

            try {
                val listResult = getLeaders.await()
                _skillLeaders.value = listResult
                Log.i("SkillNetworkCall", "Success: ${listResult.size} data fetched")
            } catch (e: Exception) {
                Log.e("SkillNetworkCall", e.toString())
                _skillLeaders.value = ArrayList()
            }
        }
    }

}