package sttp.client3

import scala.util.Try

import sttp.client3.testing.ConvertToFuture
import sttp.client3.testing.HttpTest

class TryHttpURLConnectionHttpTest extends HttpTest[Try] {

  override val backend: SttpBackend[Try, Any] = TryHttpURLConnectionBackend()
  override implicit val convertToFuture: ConvertToFuture[Try] = ConvertToFuture.scalaTry

  override def supportsHostHeaderOverride = false
  override def supportsCancellation: Boolean = false
  override def timeoutToNone[T](t: Try[T], timeoutMillis: Int): Try[Option[T]] = t.map(Some(_))
}
