/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class Utils {

    companion object {

        fun toString(data:Any?):String{
            return when(data){
                null ->"null"
                is ByteArray -> Arrays.toString(data)
                is IntArray -> Arrays.toString(data)
                is LongArray -> Arrays.toString(data)
                is DoubleArray -> Arrays.toString(data)
                is FloatArray -> Arrays.toString(data)
                is BooleanArray -> Arrays.toString(data)
                is CharArray -> Arrays.toString(data)
                is ShortArray -> Arrays.toString(data)
                data.javaClass.isArray -> Arrays.deepToString(data as Array<*>)
                else -> data.toString()
            }
        }
    }
}