/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.ea

import core.Individual

/**
 * 选择器，选择下一代
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface ISelection<G,X> {

    /**
     * 选择下一代
     */
    fun select(population:Array<Individual<G,X>>,matingPool:Array<Individual<G,X>>)
}