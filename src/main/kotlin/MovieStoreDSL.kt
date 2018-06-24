

fun main(args : Array<String>) {
    val movieStore = movieStore {
        movie {
            name = "3 Idiots"
            releaseDate = "25 Dec 2009"
            actors = listOf("Aamir Khan","adasd")
        }
    }

    println(movieStore)
}

fun movieStore(action: MovieStoreDSL.() -> Unit) : MovieStoreDSL {
    var movieStoreDSL = MovieStoreDSL()
    movieStoreDSL.action()
    return movieStoreDSL
}

class MovieDSL() {
    lateinit var name : String
    lateinit var releaseDate : String
    lateinit var actors : List<String>

    override fun toString(): String {
        return name + " " + releaseDate
    }
}

class MovieStoreDSL {
    var movie = MovieDSL()
    fun movie(action: MovieDSL.() -> Unit) : MovieDSL {
        movie.action()
        return movie
    }

    override fun toString(): String {
        return "$movie"
    }
}