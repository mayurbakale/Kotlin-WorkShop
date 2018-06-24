import java.net.URL
import java.time.LocalDate
import khttp.get
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

fun main(args : Array<String>) {
   runBlocking {
       var deferred: Deferred<OMDBMovie> = async {
           aysncFun()
       }
       println(deferred.await())
   }
}

suspend fun aysncFun() :OMDBMovie{
    val response = get(url = "http://www.omdbapi.com", params = mapOf("i" to "tt3896198", "apikey" to "*******"))
    val jsonObj = response.jsonObject
    var movie = OMDBMovie(jsonObj.getString("Plot"),
            URL(jsonObj.getString("Poster")),
            jsonObj.getString("Rated"),
            jsonObj.getDouble("imdbRating").toFloat()
    );
    return movie
}

data class OMDBMovie (var plot: String,
                      var posterImage:URL,
                      var rated: String,
                      var imdbRating: Float) {

}