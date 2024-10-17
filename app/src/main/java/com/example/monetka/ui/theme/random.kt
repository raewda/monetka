package com.example.monetka.ui.theme

import com.example.monetka.R
import kotlin.random.Random

open class RandomMonetka(
    val id : Int,
    val anim : Int
){
    object noll : RandomMonetka(0, R.raw.nullanim)
    object one : RandomMonetka(1, R.raw.oneanim)
    companion object {
        const val Count: Int = 2
        private val all = listOf(
           noll, one
        )
        fun getById(id: Int): RandomMonetka {
            all.forEach() { el ->
                if (el.id == id) return el
            }
            return noll
        }
    }
}

