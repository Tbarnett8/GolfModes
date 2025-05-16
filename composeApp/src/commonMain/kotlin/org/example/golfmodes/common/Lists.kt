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
    val appSettings = listOf(
        CareerListItem(
            "Setting 1",
            true,
        ),
        CareerListItem(
            "Setting 2",
            true,
        ),
        CareerListItem(
            "Setting 3",
            false,
        ),
    )
    val golfModesList = listOf(
        GolfModeItem(
            "Standard - Stroke Play",
            GolfModes.STANDARD
        ),
        GolfModeItem(
            "Standard - Match Play",
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
        ),
        GolfModeItem(
            "Wheel of Chaos",
            GolfModes.BREAK
        ),
        GolfModeItem(
            "Worst Ball",
            GolfModes.BREAK
        ),
        GolfModeItem(
            "All Sports Golf Battle",
            GolfModes.BREAK
        ),
        GolfModeItem(
            "Knockout Golf",
            GolfModes.BREAK
        ),
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