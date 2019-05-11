/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.searchers

import core.ISearcher
import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class RandomSearcher constructor(
        val size:Int
):ISearcher<IntArray> {
    private val random=Random()

    override fun search(): IntArray {
        val result=IntArray(size)
        val data=ArrayList<Int>()
        for (i in 0 until size){
            data.add(i)
        }
        var i=0
        while (data.isNotEmpty()){
            result[i++]=data.removeAt(random.nextInt(data.size))
        }
        return result
    }
}