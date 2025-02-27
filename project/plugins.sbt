resolvers ++= Resolver.sonatypeOssRepos("snapshots")

val sbtTypelevelVersion = "0.6.6"

addSbtPlugin("org.typelevel" % "sbt-typelevel" % sbtTypelevelVersion)
addSbtPlugin("org.typelevel" % "sbt-typelevel-site" % sbtTypelevelVersion)

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.15.0")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.17")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.3.2")

addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.4.7")

addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.5.2")
