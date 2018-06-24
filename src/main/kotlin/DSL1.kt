

class DependenciesResolver {
    private var configurations : MutableList<String> = mutableListOf()

    fun compile(configuration : String) {
        configurations.add(configuration)
    }

    fun testCompile(configuration : String) {
        configurations.add(configuration)
    }

    override fun toString(): String {
        return configurations.toString()
    }
}

fun dependencies(init: DependenciesResolver.() -> Unit) : DependenciesResolver{
    val dependencies = DependenciesResolver()
    dependencies.init()
    return dependencies
}

fun main(args: Array<String>) {
    val d = dependencies {
        compile("arrow")
        testCompile("junit")
    }

    println(d)

}