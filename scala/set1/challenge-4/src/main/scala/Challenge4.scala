package challenge4

object challenge4 {
  def scoreCharacter(c: Char) =
    if (c >= 'a' && c <= 'z' || c == ' ') 1
    else if (c >= 'A' && c <= 'Z') 0.3
    else if (c >= '0' && c <= '9') 0.2
    else if (c == ',' || c == ''') 0.1
    else 0

  def scoreCharText(txt: List[Char]) = txt.map(scoreCharacter).reduce(_ + _)

  def getOneByteXorTries(encStr: String) =
      (0 to 255).map {
        byte => {
          val charTxt =
            encStr.grouped(2).toList.map(Integer.parseInt(_, 16)).
              map(_ ^ byte).map(_.toChar)

          (byte, byte.toChar, scoreCharText(charTxt), charTxt.mkString,
            encStr)
        }
      }

  def main(args: Array[String]) {
      val source = scala.io.Source.fromFile("4.txt")
      val lines = source.mkString
      source.close()

      val tuple = lines.split('\n').flatMap(getOneByteXorTries).
        sortWith(_._3 > _._3).head

      println("Encoded text: " + tuple._4)
      println("Encoded string: " + tuple._5)
      println("Encoding character: " + tuple._2)
  }
}
