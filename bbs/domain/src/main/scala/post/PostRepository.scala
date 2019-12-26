package post

import java.util.UUID

trait PostRepository {

  def getAll(): List[Post]

  def getById(id: UUID): Option[Post]
}
