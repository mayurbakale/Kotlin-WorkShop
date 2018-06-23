import io.kotlintest.Description
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.LocalDate

class MoviesTest : FunSpec() {
    val movieStore = MovieStore();
    var moviesList : MutableList<Movie> = mutableListOf()

    override fun beforeTest(description: Description) {
        moviesList = mutableListOf(
                Movie(title = "ABCD", imdb = "ABCD", duration = 120, actors = listOf("SRK","KKR"), actress = listOf("KK","AS"),
                        releasedDate = LocalDate.of(2013, 12, 21), genre = GENRE.SUS.genre, director = "RGV"),
                Movie("DD", "DD", 110, listOf("SRK"), listOf("MD","AR"),
                        LocalDate.of(2018, 1, 21), GENRE.ROM.genre, "KJ"),
                Movie("TZH", "TZH", 105, listOf("SLK"), listOf("KK"),
                        LocalDate.of(2017, 11, 2), GENRE.ACT.genre, "AK")
        );
        movieStore.storeMovieList(moviesList);
    }

    init {
        test("movie with duration greater than 105 minutes") {
            movieStore.findMoviesWithDurationGreaterThan(105)
                    .shouldBe(listOf<String>("ABCD","DD"));
        }
    }
}