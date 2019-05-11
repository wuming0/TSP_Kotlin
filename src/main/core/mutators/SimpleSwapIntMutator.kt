/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.mutators

import core.IMutator
import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class SimpleSwapIntMutator constructor(
        private val random:Random
):IMutator<IntArray>{
    constructor():this(Random())

    override fun mutate(gene: IntArray): IntArray {
        val first=random.nextInt(gene.size)
        val last=when(first){
            0->1+random.nextInt(gene.size-1)
            gene.size-1->random.nextInt(gene.size-1)
            else->{
                if (random.nextBoolean()){
                    random.nextInt(first)
                }else{
                    first+1+random.nextInt(gene.size-first-1)
                }
            }
        }
        val result=gene.copyOf()
        val value=result[first]
        result[first]=result[last]
        result[last]=value
        require(result.size==result.toSet().size)
        return result
    }
}