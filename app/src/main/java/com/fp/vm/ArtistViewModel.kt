package com.fp.vm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.fp.data.Datasource
import com.fp.model.Artist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArtistViewModel : ViewModel() {

    private val _artists = MutableStateFlow<List<Artist>>(emptyList())
    val artists: StateFlow<List<Artist>> get() = _artists

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadArtist() {
        _artists.value = Datasource().loadArtist()
    }

}