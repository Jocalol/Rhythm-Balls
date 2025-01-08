package com.example.rhythmballs

fun WriteSong(): MutableList<SongNote> {
    var song = mutableListOf(SongNote(null, null, null, null))

    song.add(SongNote(0, 0, 0, 0))

    song.add(SongNote(secondsToFrames(2.3f), 540, 150, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(4.7f), 1020, 600, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(3.1f), 1350, 730, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(5.0f), 1670, 420, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(6.4f), 1100, 800, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(2.9f), 520, 250, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(1.7f), 1530, 180, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(3.8f), 830, 600, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(4.3f), 1620, 500, secondsToFrames(1f)));
    song.add(SongNote(secondsToFrames(2.5f), 870, 700, secondsToFrames(1f)));

    song.add(SongNote(secondsToFrames(10f), 0, 0, 0));

    return song
}

fun secondsToFrames(second : Float ) : Int {
    return ((second*60)/1.66667).toInt()
}