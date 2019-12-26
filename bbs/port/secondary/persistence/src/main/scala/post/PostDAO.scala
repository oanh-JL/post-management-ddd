package post

import java.util.UUID

import scalikejdbc.WrappedResultSet
import scalikejdbc._
import skinny.orm.{ Alias, SkinnyCRUDMapperWithId }

object PostDAO extends SkinnyCRUDMapperWithId[UUID, PostRecord] {
  override val tableName = "Post"

  override def useExternalIdGenerator = true
  override def generateId: UUID = UUID.randomUUID

  override def idToRawValue(id: UUID): Any = id.toString
  override def rawValueToId(value: Any): UUID = UUID.fromString(value.toString)

  override def primaryKeyFieldName = "id"

  override val defaultAlias: Alias[PostRecord] = createAlias("p")

  override def extract(rs: WrappedResultSet, p: ResultName[PostRecord]): PostRecord = PostRecord(
    id = rawValueToId(rs.string(p.id)),
    title = rs.get(p.title),
    content = rs.get(p.content))
}
