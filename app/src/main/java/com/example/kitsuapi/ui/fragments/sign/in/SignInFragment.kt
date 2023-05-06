package com.example.kitsuapi.ui.fragments.sign.`in`

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.data.local.preferences.PreferenceHelper
import com.example.kitsuapi.data.local.preferences.UserPreferencesData
import com.example.kitsuapi.databinding.FragmentSignInBinding
import com.example.kitsuapi.extensions.toast
import com.example.kitsuapi.models.auth.AuthModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BaseFragment<SignInViewModel, FragmentSignInBinding>(
    R.layout.fragment_sign_in
) {
    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val viewModel: SignInViewModel by viewModels()
    override val binding by viewBinding(FragmentSignInBinding::bind)

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    override fun setupSubscribers() = with(binding) {
        binding.btnButton.setOnClickListener {
            val email = edGmail.text.toString()
            val password = edPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")
                },
                onSuccess = {
                    if (it != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = it.accessToken
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment)
                            .navigate(R.id.action_signFlowFragment_to_mainFlowFragment)
                    }
                }
            )
        }
    }
}