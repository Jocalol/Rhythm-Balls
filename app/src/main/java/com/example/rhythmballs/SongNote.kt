package com.example.rhythmballs

data class SongNote (
    var timestamp: Int?,
    var x: Int?,
    var y: Int?,
    var decaySpeed: Int?) {
    constructor() : this(null, null, null, null)
}