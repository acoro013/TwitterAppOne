package com.codepath.apps.restclienttemplate.models

import org.json.JSONObject

class User {

    var name: String = ""
    var screenName: String = ""
    var publicImageUrl: String = ""

    //something we can reference
    //companion objects are singleton objects whose properties and functions are tied
    // to a class but not to the instance of that class — basically like the “static”
    // keyword in Java but with a twist.
    companion object{
        fun fromJson(jsonObject: JSONObject): User {
            val user = User()
            user.name = jsonObject.getString("name")
            user.screenName = jsonObject.getString("screen_name")
            user.publicImageUrl = jsonObject.getString("profile_image_url_https")
            return user
        }
    }

}