class WeatherForecast(
    val year: String,
    val month: String,
    val day: String,
    val dayOfTheWeek: String,
    val weather: String,
) {
    override fun toString(): String {
        return "$year-$month-$day $dayOfTheWeek $weather"
    }
}


fun main() {
    val n = readLine()!!.toInt()
    val forecasts = mutableListOf<Triple<String, String, String>>()
    for (i in 1..n) {
        val (date, day, weather) = readln().split(" ")
        forecasts.add(Triple(date, day, weather))
    }

    val weatherForecasts = forecasts.map { 
        val date = it.first.split("-")
        WeatherForecast(date[0], date[1], date[2], it.second, it.third) 
    }
    var result: WeatherForecast? = null

    for (weatherForecast in weatherForecasts) {
        if (result == null && weatherForecast.weather == "Rain") {
            result = weatherForecast
        } else if (result != null && 
            weatherForecast.weather == "Rain" &&
            weatherForecast.year.toInt() < result.year.toInt()
        ) {
            result = weatherForecast
        } else if (result != null && 
            weatherForecast.weather == "Rain" &&
            weatherForecast.year.toInt() == result.year.toInt() &&
            weatherForecast.month.toInt() < result.month.toInt()
        ) {
            result = weatherForecast
        } else if (result != null && 
            weatherForecast.weather == "Rain" &&
            weatherForecast.year.toInt() == result.year.toInt() &&
             weatherForecast.month.toInt() == result.month.toInt() &&
            weatherForecast.day.toInt() < result.day.toInt()
        ) {
            result = weatherForecast
        }
    }

    println(result)
}
