package com.sumpaulo.ecommerce_jetpack.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sumpaulo.ecommerce_jetpack.core.Config.AUTH_KEY
import com.sumpaulo.ecommerce_jetpack.domain.model.AuthResponse
import com.sumpaulo.ecommerce_jetpack.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


class AuthDataStore constructor(private val dataStore: DataStore<Preferences>){

    suspend fun saveUser(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }

    }


    suspend fun update(user: User){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        val authResponse = runBlocking {
            getData().first()
        }
        authResponse.user?.name = user.name
        authResponse.user?.lastname = user.lastname
        authResponse.user?.phone = user.phone

        if(!user?.image.isNullOrBlank())
            authResponse.user?.image = user.image

        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }

    }

    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref.remove(dataStoreKey)
        }

    }



    fun getData() : Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if(pref[dataStoreKey] != null){
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }else{
                AuthResponse()
            }
        }
    }
}