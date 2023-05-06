package com.example.kitsuapi.ui.fragments.sign.`in`

import com.example.kitsuapi.base.BaseViewModel
import com.example.kitsuapi.data.repositories.SignInRepository
import com.example.kitsuapi.models.auth.AuthModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: SignInRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}