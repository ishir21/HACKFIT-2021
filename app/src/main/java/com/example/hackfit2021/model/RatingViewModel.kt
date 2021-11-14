package com.example.hackfit2021.Model

import androidx.lifecycle.*
import com.example.hackfit2021.database.JournalsDatabase
import com.example.hackfit2021.entities.Rating
import kotlinx.coroutines.launch

class RatingViewModel(val database: JournalsDatabase): ViewModel() {

    private val _ratingsList: MutableLiveData<List<Rating>> =MutableLiveData()
    val ratingsList : LiveData<List<Rating>> = _ratingsList

    private val _ratings: MutableLiveData<Rating> =MutableLiveData()
    val ratings : LiveData<Rating> = _ratings

    fun insert(rating:Int,date:String) = viewModelScope.launch{
        database.ratingsDao().insertRating(Rating(rating, date))
        getAllRatings()
    }

    fun delete(rating:Rating) = viewModelScope.launch {
        database.ratingsDao().deleteRating(rating)
    }

    fun update(rating: Rating) = viewModelScope.launch {
        database.ratingsDao().updateRating(rating)
    }

    fun getAllRatings() = viewModelScope.launch {
        val ratings = database.ratingsDao().getAllRatings()
        _ratingsList.postValue(ratings)
    }
    fun getRating(date:String) = viewModelScope.launch {
        val ratings = database.ratingsDao().getRating(date)
        _ratings.postValue(ratings)
    }
}

class RatingViewModelFactory(
    private val database: JournalsDatabase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RatingViewModel(database) as T
    }
}