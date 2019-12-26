package post

import java.util.UUID

class PostRepoImpl extends PostRepository {
  override def getAll(): List[Post] = PostDAO.findAll()

  override def getById(id: UUID): Option[Post] = PostDAO.findById(id)
}
