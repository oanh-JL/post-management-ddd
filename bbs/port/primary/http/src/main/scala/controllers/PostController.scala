package controllers

import javax.inject.Inject
import play.api.i18n.I18nSupport
import play.api.libs.json._
import play.api.mvc._
import post.PostRepository

class PostController @Inject()(cc: ControllerComponents, postRepo: PostRepository)
  extends AbstractController(cc) with I18nSupport {

  def posts() = Action { implicit request: Request[AnyContent] =>
    val posts = postRepo.getAll()
    Ok(Json.toJson(posts))
  }
}
