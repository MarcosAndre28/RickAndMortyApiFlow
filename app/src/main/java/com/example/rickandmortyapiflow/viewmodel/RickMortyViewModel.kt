package com.example.rickandmortyapiflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyapiflow.api.ApiService
import com.example.rickandmortyapiflow.paging.RickMortyPaginSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*Pager : Essa API consome o que o RemoteMediator ou PagingSource retorna como uma
fonte de dados para ele e retorna um fluxo reativo de PagingData . Ele pode ser retornado
como Flow, Observable, LiveData, conforme mostrado no diagrama acima.*/

@HiltViewModel
class RickMortyViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)){
        RickMortyPaginSource(apiService)
    }.flow.cachedIn(viewModelScope)
}