package com.example.kitsuapi.data.local.preferences

import javax.inject.Inject

const val PREF_IS_AUTHORIZED = "is_authorized"
const val PREF_ACCESS_TOKEN: String = "access_token"
const val PREF_REFRESH_TOKEN: String = "refresh_token"

class UserPreferencesData @Inject constructor(
    private val preferencesHelper: PreferenceHelper
) {

    var isAuthorized: Boolean
        get() = preferencesHelper().getBoolean(PREF_IS_AUTHORIZED, false)
        set(value) = preferencesHelper().edit().putBoolean(PREF_IS_AUTHORIZED, value).apply()

    var accessToken: String
        get() = preferencesHelper().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preferencesHelper().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = preferencesHelper().getString(PREF_REFRESH_TOKEN, "null")!!
        set(value) = preferencesHelper().edit().putString(PREF_REFRESH_TOKEN, value).apply()
}