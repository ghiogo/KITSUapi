package com.example.kitsuapi.data.repositories

import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiservices.SignApiService
import com.example.kitsuapi.models.auth.AuthModel
import javax.inject.Inject

class SignInRepository @Inject constructor(
    private val signApiServices: SignApiService
) : BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest{
        signApiServices.postAuthDataUser(authModel)
    }
}