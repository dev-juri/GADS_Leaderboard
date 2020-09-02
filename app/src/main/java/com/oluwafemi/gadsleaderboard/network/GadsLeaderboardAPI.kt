package com.oluwafemi.gadsleaderboard.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.oluwafemi.gadsleaderboard.models.SkillLeaders
import com.oluwafemi.gadsleaderboard.models.TimeLeaders
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val LEADERS_BASE_URL = "https://gadsapi.herokuapp.com"
const val SUBMISSION_BASE_URL = "https://docs.google.com/forms/d/e/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())

val leaderboardRetrofit = retrofit.baseUrl(LEADERS_BASE_URL)
    .build()

val submissionRetrofit = retrofit.baseUrl(SUBMISSION_BASE_URL)
    .build()

interface GadsAPIService {
    @GET("/api/hours")
    fun getLearningLeaders(): Deferred<List<TimeLeaders>>

    @GET("/api/skilliq")
    fun getSkillLeaders(): Deferred<List<SkillLeaders>>
}

interface Submission {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun codeSubmission(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") githubLink: String
    ): Call<Void>
}

object GadsLeaderboardAPI {
    val GadsService : GadsAPIService by lazy {
        leaderboardRetrofit.create(GadsAPIService::class.java)
    }
    val submissionService : Submission by lazy {
        submissionRetrofit.create(Submission::class.java)
    }
}
