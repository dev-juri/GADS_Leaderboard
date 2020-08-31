package com.oluwafemi.gadsleaderboard.models

data class TimeLeaders(
    val name : String,
    val hours : String,
    val country : String,
    val badgeUrl : String
)

data class SkillLeaders (
    val name : String,
    val score : String,
    val country: String,
    val badgeUrl: String
)