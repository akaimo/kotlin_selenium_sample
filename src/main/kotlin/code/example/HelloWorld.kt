package code.example

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns

fun main(args: Array<String>) {
    println("Hello World!!")

    val request = LauncherDiscoveryRequestBuilder().filters(includeClassNamePatterns(".*Test"))
}
