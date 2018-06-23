import java.time.LocalDate
import java.util.*


enum class GENRE (val genre : String) {
    ACT("Act"),
    SUS("Sus"),
    ROM("Rom")
}

fun main(args : Array<String>) {
    val store : MovieStore = MovieStore.create();
    println("Movies with release year 2018");
    store.findReleaseMoviesPerYear(2018);

    println("Movies with duration greater than 105");
    store.findMoviesWithDurationGreaterThan(105);

    println("Movies with Actor SRK");
    store.findMoviesWithGivenActor("SRK");

    println("Movies with Actress KK");
    store.findMoviesWithGivenActress("KK");

    println("Add Movie to the List")
    val movie : Movie = Movie(title = "ABCD2", imdb = "ABCD2", duration = 120, actors = listOf("SRK","KKR"), actress = listOf("KK","AS"), releasedDate = LocalDate.of(2016, 5, 10), genre = GENRE.SUS.genre, director = "RGV")
    +movie
}



data class Movie (val title: String,
    val imdb : String,
    val duration : Int,
    val actors: List<String>,
    val actress: List<String>,
    val releasedDate : LocalDate,
    val genre : String,
    val director : String) {

    fun releasedIn(ryear : Int) = releasedDate.year == ryear

    operator fun unaryPlus() {
        MovieStore.create().addMovieInList(this)
    }
}

class MovieStore {

    companion object Factory {
        fun create() : MovieStore = MovieStore()
    }

    var moviesList : MutableList<Movie> = mutableListOf();

    init {
        moviesList = mutableListOf(
                Movie(title = "ABCD", imdb = "ABCD", duration = 120, actors = listOf("SRK","KKR"), actress = listOf("KK","AS"),
                        releasedDate = LocalDate.of(2013, 12, 21), genre = GENRE.SUS.genre, director = "RGV"),
                Movie("DD", "DD", 110, listOf("SRK"), listOf("MD","AR"),
                        LocalDate.of(2018, 1, 21), GENRE.ROM.genre, "KJ"),
                Movie("TZH", "TZH", 105, listOf("SLK"), listOf("KK"),
                        LocalDate.of(2017, 11, 2), GENRE.ACT.genre, "AK"),
                Movie("STS", "STS", 145, listOf("SLK","SAK","ASD"), listOf("SS"),
                        LocalDate.of(2014, 6, 10), GENRE.SUS.genre, "RGV"),
                Movie("HNY", "HNY", 120, listOf("SRK"), listOf("DP"),
                        LocalDate.of(2016, 7, 12), GENRE.ACT.genre, "KJ")
        );
        /*moviesList = listOf<Movie>(
                Movie(title = "ABCD", imdb = "ABCD", duration = 120, actors = listOf("SRK","KKR"), actress = listOf("KK","AS"),
                        releasedDate = LocalDate.of(2013, 12, 21), genre = GENRE.SUS.genre, director = "RGV"),
                Movie("DD", "DD", 110, listOf("SRK"), listOf("MD","AR"),
                        LocalDate.of(2018, 1, 21), GENRE.ROM.genre, "KJ"),
                Movie("TZH", "TZH", 105, listOf("SLK"), listOf("KK"),
                        LocalDate.of(2017, 11, 2), GENRE.ACT.genre, "AK"),
                Movie("STS", "STS", 145, listOf("SLK","SAK","ASD"), listOf("SS"),
                        LocalDate.of(2014, 6, 10), GENRE.SUS.genre, "RGV"),
                Movie("HNY", "HNY", 120, listOf("SRK"), listOf("DP"),
                        LocalDate.of(2016, 7, 12), GENRE.ACT.genre, "KJ")
        );*/
    }

    fun storeMovieList(movieList : MutableList<Movie>) {
        moviesList = movieList;
    }

    // findReleaseMoviesPerYear
    fun findReleaseMoviesPerYear(year : Int)  {
        for (movie in moviesList) {
            if(movie.releasedIn(year)) {
                println(movie.toString());
            }
        }
    }

    //findMoviesWithDurationGreaterThan
    fun findMoviesWithDurationGreaterThan(duration : Int) : List<String> {
        var titleList : MutableList<String> = mutableListOf();
        for (movie in moviesList) {
            if(movie.duration in duration+1..300) {
                println(movie.toString());
                titleList.add(movie.title);
            }
        }
        return titleList;
    }

    //findMoviesWithGivenActor
    fun findMoviesWithGivenActor(actor : String)  {
        for (movie in moviesList) {
            for (actorName in movie.actors) {
                if(actorName.equals(actor)){
                    println(movie.toString());
                }
            }
        }
    }

    //findMoviesWithGivenActress
    fun findMoviesWithGivenActress(actress : String)  {
        for (movie in moviesList) for (actressName in movie.actress) {
            if(actressName.equals(actress)){
                println(movie.toString());
            }
        }
    }

    fun addMovieInList(movie : Movie) {
        moviesList.add(movie);
        println(moviesList);
    }

}