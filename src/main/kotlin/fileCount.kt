import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.function.Function
import java.util.stream.Collectors

fun main(args: Array<String>) {
    val path = Paths.get("E:\\Kotlin ThoughtWorks\\thoughtworksprovided\\kotlin-training-scratchpad\\src\\main\\resources\\word-count.txt")

    Files
            .readAllLines(path)
            .flatMap { it.split(" ") }
            .groupingBy { it }
            .eachCount()
            .forEach{word,count -> println("$word = $count")};
}