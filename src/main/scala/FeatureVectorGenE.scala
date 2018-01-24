/**
  * Created by takeyuki miyagi (m5211139) on 18/01/23.
  */
object FeatureVectorGenE {
  def genFeatureVectorE(documents: Seq[EngDocument]): (Map[EngDocument, Seq[Double]], Set[Word]) = {
    val tfMap : Map[EngDocument, Map[Word, Int]] =
      documents.map(d => (d, d.wordFreq)).toMap

    val allWords: Set[Word] =
      documents.flatMap(d => d.wordSet).toSet

    val dfMap : Map[Word, Int] =
      allWords.map(w =>
        (w, documents.count(_.wordSet.contains(w)))
      ).toMap

    val featureVectors: Map[EngDocument, Seq[Double]] =
      documents.map { d =>
        val N = documents.size
        val vector: Seq[Double] = allWords.toSeq.map(w =>
          tfMap(d)(w) * Math.log(N.toDouble / dfMap(w))
        )
        (d, vector)
      }.toMap

    (featureVectors, allWords)
  }
}

