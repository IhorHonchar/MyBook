package ua.vrgsoft.honchar.mybook.utils

object TimeUtils {

    fun millisecondsToTime(time: Long): String {
        val totalSeconds = time / 1000
        val h = totalSeconds / 3600
        val m = (totalSeconds / 60) % 60
        val s = totalSeconds % 60

        val minutes = if (m < 10) "0$m" else "$m"
        val seconds = if (s < 10) "0$s" else "$s"
        return if (h > 0) "$h:$minutes:$seconds" else "$minutes:$seconds"
    }

}