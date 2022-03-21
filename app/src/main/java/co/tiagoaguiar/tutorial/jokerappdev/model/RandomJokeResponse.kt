package co.tiagoaguiar.tutorial.jokerappdev.model

import com.google.gson.annotations.SerializedName

data class RandomJokeResponse (
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("value") val value: String
)


