package com.example.twemojidemo

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import com.example.twemojidemo.databinding.ActivityMainBinding
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.twitter.TwitterEmojiProvider


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val twitterEmojiProvider = TwitterEmojiProvider()
        EmojiManager.install(twitterEmojiProvider)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var editableText = SpannableStringBuilder()
        twitterEmojiProvider.categories.forEach { emojiCategory ->
            emojiCategory.emojis.forEach { emoji ->
                editableText.append(emoji.unicode)
            }
        }
        binding.textview.text = editableText
    }


}