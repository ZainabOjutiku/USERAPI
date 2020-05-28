package com.simpleapi.controller

import com.redis.RedisClient
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging

class UserController extends Controller with Logging {
  val clients2 = new RedisClient("localhost", 6379)

  get("/auser") { request: Request =>
    info("request got here")
    val allUsers = clients2.hgetall("people")
    println(s"printing a user = ${allUsers}")

  }

  post("/auser/:id/:name") { request: Request =>
    info(s" this is a post route")
    val name = request.getParam("name")
    val id = request.getParam("id")
    val user = clients2.hset("people", id: String, name: String)
    info(s" tSetting a ${user} with name ${name} and id ${id}")
  }

  put("/auser/:id") { request: Request =>
    val auser = request.getParam("id")
    println(s"this is  request param with id ${auser}")
    val exist = clients2.hexists("people", auser)
    val user = clients2.hget("people", auser).get
    println(s"this person ${auser} exist ${exist} and gotten id ${user}")
    val newname = user + "ojo"
    val update = clients2.hset("people", auser: String, newname: String)
    println(s"updating the user ${update} with the newname ${newname}")
    val newupdate = clients2.hgetall("people")
    println(s"printing a all user = ${newupdate}")

  }

  delete("/auser/del/:user") { request: Request =>
    info(s" this is a delete route")
    val user = request.getParam("user")
    if (clients2.hexists("people", user)) {
      val delete = clients2.hdel("people", user: String)
      info(s"Deleted a User${delete}")
      val newupdate2 = clients2.hgetall("people")
      println(s"the new user after deleting = ${newupdate2}")
    } else {
      info("user doesn't exist")
    }

  }
}
