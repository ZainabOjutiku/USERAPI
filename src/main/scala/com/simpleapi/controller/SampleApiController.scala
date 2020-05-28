package com.simpleapi.controller

import com.redis.RedisClient
import com.redis.serialization._
import com.simpleapi.modules.UserRequest
import com.twitter.finagle.http.Request
import com.twitter.finatra.http._
import com.twitter.inject.Logging
import com.twitter.util.Future
import scala.collection.mutable

class SampleApiController extends Controller with Logging {
//  val clients = new RedisClient("localhost", 6379)

//  get("/") { request: Request =>
//    //    val Us = request.getParam("name")
//    info("request got here")
//    println(s"request got here")
//    val users = clients.hgetall("individual")
//    println(s"printing a user = ${users}")
////    val user1 = clients.get("user")
////    info(s"this is a user ${user1}")
//  }
//
//  post("/user/:name/:id") { userrequest: UserRequest =>
//    info(s" this is a post route")
//    val name = userrequest.name
//    val id = userrequest.id
//    println(s"name = ${name} and id = ${id}")
//    val user = clients.hmset("individual", Map(name -> id))
//    info(s" this is a post route for ${user}")
//    println(s"name = ${name} and id = ${id}")
////    val exist = clients.hexists()
////    val name = userrequest.name
////    val users = clients.set("user", name)
////    info(s"this is a user post ${users}")
//
//  }
//
//  put("/user/:users") { request: Request =>
////    val name = request.getParam("users")
////    val exist = clients.hexists("individual", name)
////    info(s"this person ${users} exist ${exist} ")
////    val newname = users + " ojutiku"
////    val update = clients.set("individual", name, newname)
////    info(s"this is after updating ${newname}")
////    info(s"this is  update ${update}")
////    val newupdate = clients.hgetall("person")
////    println(s"printing a all user = ${newupdate}")
//    //    val useR: Option[String] = clients.get("user")
////    info(s"routeparam =${person} database param = ${useR}")
////    useR match {
////      case Some(name) =>
////        if (person == name) {
////          val name1 = name
////          println(s"name ${name1}, person = ${person}")
////          val newname = name + " ojutiku"
////          clients.set("user", newname)
////          c
////        }
////      case None => "not found"
//    //}
//  }
//  delete("/user/:user") { request: Request =>
//    }
}
