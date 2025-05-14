package org.example.golfmodes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform