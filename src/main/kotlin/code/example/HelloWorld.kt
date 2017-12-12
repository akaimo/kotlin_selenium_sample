package code.example

import org.junit.platform.commons.util.ReflectionUtils
import org.junit.platform.engine.TestEngine
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.engine.discovery.ClassNameFilter.*
import org.junit.platform.engine.discovery.DiscoverySelectors
import org.junit.platform.launcher.EngineFilter.*
import org.junit.platform.launcher.TagFilter.*
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener
import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!!")

    val testEngine = ServiceLoader.load(TestEngine::class.java)
    val launcher = LauncherFactory.create()
    val summary = SummaryGeneratingListener()
    launcher.registerTestExecutionListeners(summary)
    val request = LauncherDiscoveryRequestBuilder
            .request()
//            .selectors(selectPackage("sample.e2e"))
            .selectors(DiscoverySelectors.selectPackage("sample.e2e"))
            .filters(includeClassNamePatterns(".*"))
            .build()
    launcher.execute(request)
    summary.summary.printTo(PrintWriter(System.out))

//    val request = LauncherDiscoveryRequestBuilder
//            .request()
//            .selectors(selectPackage("sample.e2e"))
//            .filters(includeClassNamePatterns(".*"))
//            .build()
//    val plan = LauncherFactory.create().discover(request)
//    val launcher = LauncherFactory.create()
//    val summaryGeneratingListener = SummaryGeneratingListener()
//    launcher.execute(
//            request,
//            summaryGeneratingListener
//    )
//    println(summaryGeneratingListener.summary)
}
