import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class HelloWorldUnitTest : FunSpec() {

    init {
        test("should return hello world"){
            val helloWorld = helloWorld()
            helloWorld shouldBe "Hello World"
        }
    }
}