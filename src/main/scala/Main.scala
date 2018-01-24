/**
  * Created by takeyuki miyagi (m5211139) on 18/01/23.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val documents : Seq[EngDocument] = Seq(
      EngDocument("weather is fine rainy."),
      EngDocument("weather cloudy fine."),
      EngDocument("basketball baseball soccer baseball")
    )

    val (featureVectors, allWords) = FeatureVectorGenE.genFeatureVectorE(documents)

    println("=== All words ===")
    println(allWords)

    for((doc, featureVec) <- featureVectors) {
      println("--- Document ---")
      println(doc)
      println("--- Feature Vector ---")
      println(featureVec.map(e => "%.2f".format(e)).mkString("(", ", ", ")"))
      println()
    }
  }
}
