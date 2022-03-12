package com.codepath.apps.restclienttemplate

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetAdapter.ViewHolder>() {

    //resposible for inflating the layout we want to use for each of the items we watn to use in our recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        //inflate our item layout
        val view = inflater.inflate(R.layout.item_tweet, parent, false)
        return ViewHolder(view)
    }

    //populating data into the item thru the viewHolder
    //looking at layout for each tweet item, and populating the data for each of those views based on the tweets
    override fun onBindViewHolder(holder: TweetAdapter.ViewHolder, position: Int) {
        //get the datat model based on the position
        val tweet: Tweet = tweets.get(position)

        //set item views based on views and data model

        //referencing form Tweet object
        //? if user wasnt parsed succesfully, the name will just be blank
        holder.tvUserName.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body

        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivProfileImage)
    }

    //tells adapter how many views are gonna be in the recycler view
    //returns size of list of tweets
    override fun getItemCount(): Int {
        return tweets.size
    }

    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }

    //needs to reference everything inside our item_tweet activity
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
    }
}