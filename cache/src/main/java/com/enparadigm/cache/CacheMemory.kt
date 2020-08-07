package com.enparadigm.cache

import android.graphics.Bitmap
import android.util.Log
import java.util.*
import kotlin.collections.LinkedHashMap

class CacheMemory {

    private var  cache : MutableMap<String,Bitmap> = Collections.synchronizedMap(LinkedHashMap<String,Bitmap>(10,1.5f,true))
    private var size: Long= 0
    private var limit : Long=100000;
    companion object {
        private val TAG: String = "MyCache"
    }

    init {
       setLimit(Runtime.getRuntime().maxMemory()/8)
    }

    private fun setLimit(lim: Long) {
         limit= lim
    }

    operator fun get(id: String?): Bitmap? {
        return try {
            if (!cache.containsKey(id)) null else cache[id]
        } catch (ex: NullPointerException) {
            ex.printStackTrace()
            null
        }
    }

    fun put(id: String?, bitmap: Bitmap?) {
        try {
            if (cache.containsKey(id)) size -= getSizeInBytes(cache[id])
            cache.put(id!!, bitmap!!)
            size += getSizeInBytes(bitmap)
            checkSize()
        } catch (th: Throwable) {
            th.printStackTrace()
        }
    }

    private fun checkSize() {
        if (size > limit) {
            val iter: MutableIterator<Map.Entry<String, Bitmap>> =
                cache.entries.iterator()
            while (iter.hasNext()) {
                val entry = iter.next()
                size -= getSizeInBytes(entry.value)
                iter.remove()
                if (size <= limit) break
            }
            Log.i(
               TAG,
                "Clean cache. New size " + cache.size
            )
        }
    }

    fun clear() {
        try {
            cache.clear()
            size = 0
        } catch (ex: java.lang.NullPointerException) {
            ex.printStackTrace()
        }
    }

    fun getSizeInBytes(bitmap: Bitmap?): Long {
        return if (bitmap == null) 0 else (bitmap.rowBytes * bitmap.height).toLong()
    }
}