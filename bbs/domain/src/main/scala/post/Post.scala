package post

import java.util.UUID

trait Post {
  val id: UUID
  val title: String
  val content: String
}

object Post {
  def apply(id: UUID, title: String, content: String): Post = Post(id, title, content)
}