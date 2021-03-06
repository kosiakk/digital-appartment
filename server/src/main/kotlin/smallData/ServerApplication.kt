package smallData

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ServerApplication {

}

fun main(args: Array<String>) {
    val context = SpringApplication.run(ServerApplication::class.java, *args)

}
