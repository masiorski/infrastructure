package com.atlassian.performance.tools.infrastructure.api.jvm

import com.atlassian.performance.tools.infrastructure.PreinstalledJDK
import com.atlassian.performance.tools.infrastructure.api.os.Ubuntu
import com.atlassian.performance.tools.ssh.api.SshConnection
import java.time.Duration

class OpenJDK11 : VersionedJavaDevelopmentKit {
    override val jstatMonitoring: Jstat = Jstat("")

    override fun getMajorVersion() = 11

    override fun install(connection: SshConnection) {
        Ubuntu().install(
            connection,
            listOf("openjdk-11-jdk"),
            Duration.ofMinutes(5)
        )
    }

    override fun use(): String {
        return ""
    }

    override fun command(options: String): String {
        return "java $options"
    }

    fun toPreinstalledJdk(): JavaDevelopmentKit = PreinstalledJDK(javaBin = "java", jstatMonitoring = jstatMonitoring)
}