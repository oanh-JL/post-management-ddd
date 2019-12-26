package modules

import com.google.inject.AbstractModule
import post.{PostRepoImpl, PostRepository}

class BatchModules extends AbstractModule {
  lazy val postRepo: PostRepository = new PostRepoImpl()

  override def configure(): Unit = {
    bind(classOf[PostRepository]).toInstance(postRepo)
  }
}
