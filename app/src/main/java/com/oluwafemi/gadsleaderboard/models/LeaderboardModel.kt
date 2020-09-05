package com.oluwafemi.gadsleaderboard.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class TimeLeaders(
    val name: String,
    val hours: String,
    val country: String,
    val badgeUrl: String
) {
    val contentDescription: String = "$hours learning hours, $country"
}

data class SkillLeaders(
    val name: String,
    val score: String,
    val country: String,
    val badgeUrl: String
) {
    val contentDescription: String = "$score skill IQ Score, $country"
}

@Parcelize
data class Submission(
    val emailAddress: String,
    val firstName: String,
    val lastName: String,
    val submissionLink: String
) : Parcelable