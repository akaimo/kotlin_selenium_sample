package code.example

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.engine.discovery.ClassNameFilter.*
import org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener
import java.io.PrintWriter

fun main(args: Array<String>) {
    println("Hello World!!")

    val launcher = LauncherFactory.create()
    val summary = SummaryGeneratingListener()
    launcher.registerTestExecutionListeners(summary)
    val request = LauncherDiscoveryRequestBuilder
            .request()
            .selectors(selectPackage("sample.e2e"))
            .filters(includeClassNamePatterns(".*"))
            .build()
    launcher.execute(request)
    summary.summary.printTo(PrintWriter(System.out))
}
