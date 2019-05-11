/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.ea

import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/24 20:05
 */
class CombineTwoIntArray:IHybridOperate<IntArray> {
    private val random=Random()

    override fun recombine(father: IntArray, mother: IntArray): IntArray {
        require(father.size==mother.size)
        val result=IntArray(father.size)
        val set= hashSetOf<Int>()
        for (i in 0 until father.size){
            if (father[i]!=mother[i]) {
                set.add(father[i])
            }
        }
        for (i in 0 until result.size){
            if (father[i]==mother[i]){
                result[i]=father[i]
            }else{
                if (random.nextBoolean()){
                    if (father[i] in set){
                        result[i]=father[i]
                    }else{
                        if (mother[i] in set){
                            result[i]=mother[i]
                        }else{
                            result[i]=set.first()
                        }
                    }
                }else{
                    if (mother[i] in set){
                        result[i]=mother[i]
                    }else{
                        if (father[i] in set){
                            result[i]=father[i]
                        }else{
                            result[i]=set.first()
                        }
                    }
                }
                set.remove(result[i])
            }
        }
        return result
    }
}