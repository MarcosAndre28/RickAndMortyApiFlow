package com.example.rickandmortyapiflow.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapiflow.api.ApiService
import com.example.rickandmortyapiflow.model.RickMorty

/*PagingSource : É uma classe abstrata genérica que é responsável por carregar os dados de paginação da rede.
Para implementar PagingSource precisamos definir o tipo Page Key no nosso caso será do tipo Int e o tipo de
dados de resposta da API no nosso caso será RickMorty.*/

class RickMortyPaginSource(private val apiService: ApiService) : PagingSource<Int, RickMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMorty> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<RickMorty>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }

}