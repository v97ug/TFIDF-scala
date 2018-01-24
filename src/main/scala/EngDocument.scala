/**
  * Created by takeyuki miyagi (m5211139) on 18/01/23.
  */
case class EngDocument(document: String) {
  lazy val wordFreq: Map[Word, Int] =
    document.split(" ")
      .map(Word)
      .groupBy(identity)
      .map { case (k, v) => (k, v.length) }
      .withDefaultValue(0)

  lazy val wordSet: Set[Word] =
    document.split(" ").map(Word).toSet
}
