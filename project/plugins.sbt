val sbtTypelevelVersion = "0.4.3"
addSbtPlugin("org.typelevel" % "sbt-typelevel" % sbtTypelevelVersion)
addSbtPlugin("org.typelevel" % "sbt-typelevel-site" % sbtTypelevelVersion)

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.8.0")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.3")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.1.0")