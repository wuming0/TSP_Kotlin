/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.ea.selections

import core.Individual
import core.algorithms.ea.ISelection
import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/24 19:54
 */
class TruncationSelection<G,X>:ISelection<G,X> {

    override fun select(population: Array<Individual<G, X>>, matingPool: Array<Individual<G, X>>) {
        Arrays.sort(population)
        System.arraycopy(population,0,matingPool,0,matingPool.size)
    }
}