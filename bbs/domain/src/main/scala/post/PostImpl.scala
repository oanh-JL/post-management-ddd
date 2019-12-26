package post

import java.util.UUID

case class PostImpl(id: UUID, title: String, content: String) extends Post
