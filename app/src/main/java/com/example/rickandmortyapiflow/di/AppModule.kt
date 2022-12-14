package com.example.rickandmortyapiflow.di

import com.example.rickandmortyapiflow.api.ApiService
import com.example.rickandmortyapiflow.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun providerRetrofitInstance(BASE_URL: String) : ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}
/*@Module anota o objeto para indicar que obteremos nossas dependências daqui. Usaremos apenas um neste aplicativo simples,
 mas projetos de maior escala geralmente têm muitos módulos.

 @Singleton forçará que apenas uma instância da dependência seja criada e usada em todo o aplicativo.

 @Provides indica que a próxima função fornecerá uma dependência.*/