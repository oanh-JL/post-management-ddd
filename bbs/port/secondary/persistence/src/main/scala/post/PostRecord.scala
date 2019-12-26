package post

import java.util.UUID

case class PostRecord(id: UUID, title: String, content: String) extends Post
