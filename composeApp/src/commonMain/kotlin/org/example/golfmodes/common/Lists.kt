package org.example.golfmodes.common

import kotlinx.serialization.Serializable

object Lists{
    val careerSettings = listOf(
        CareerListItem(
            "Club distances",
            true,
        ),
        CareerListItem(
            "Handicap",
            true,
        ),
        CareerListItem(
            "Best round",
            false,
        ),
    )
    val golfModesList = listOf(
        GolfModeItem(
            "Standard",
            GolfModes.STANDARD
        ),
        GolfModeItem(
            "Random Club",
            GolfModes.RANDOM_CLUB
        ),
        GolfModeItem(
            "Better Ball",
            GolfModes.BETTER_BALL
        ),
        GolfModeItem(
            "Scramble",
            GolfModes.SCRAMBLE
        ),
        GolfModeItem(
            "Alternate Shot",
            GolfModes.ALTERNATE_SHOT
        ),
        GolfModeItem(
            "Break _",
            GolfModes.BREAK
        )
    )
}

@Serializable
data class GolfModeItem(
    val name: String,
    val mode: GolfModes,
)

@Serializable
data class Scorecard(
    val mode: GolfModes,
    val playersNum: Int,
)

data class CareerListItem(
    val name: String,
    val showMore: Boolean,
)

enum class GolfModes{
    STANDARD,
    RANDOM_CLUB,
    BETTER_BALL,
    SCRAMBLE,
    ALTERNATE_SHOT,
    BREAK,
}