package com.oluwafemi.gadsleaderboard.models

import com.google.gson.annotations.JsonAdapter


data class TimeLeaders(
    val name : String,
    val hours : String,
    val country : String,
    val badgeUrl : String
) {
    val contentDescription : String = "$hours learning hours, $country"
}

data class SkillLeaders (
    val name : String,
    val score : String,
    val country: String,
    val badgeUrl: String
) {
    val contentDescription : String = "$score skill IQ Score, $country"
}