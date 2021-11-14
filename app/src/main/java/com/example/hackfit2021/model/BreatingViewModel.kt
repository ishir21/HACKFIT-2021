package com.example.hackfit2021.model

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class BreathingViewModel: ViewModel() {

    private val timer: CountDownTimer

    private val _currentTimer = MutableLiveData<Long>()
    val currentTimer: LiveData<Long> = _currentTimer

    private val _timeDone = MutableLiveData<Boolean>()
    val timeDone: LiveData<Boolean> = _timeDone

    val currentTimeString = Transformations.map(currentTimer) { time ->
        DateUtils.formatElapsedTime(time)
    }

    init {
        timer = object : CountDownTimer(COUNT_DOWN_TIME,1000L){
            override fun onTick(p0: Long) {
                _currentTimer.value = p0/1000L
            }

            override fun onFinish() {
                _currentTimer.value = 0L
                onTimeDone()
            }
        }
        timer.start()
    }

    fun onTimeDone() {
        _timeDone.postValue(true)
    }

    fun onTimeDoneFinish(){
        _timeDone.postValue(false)
    }

    companion object{
        const val COUNT_DOWN_TIME = 60000L
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }


}
