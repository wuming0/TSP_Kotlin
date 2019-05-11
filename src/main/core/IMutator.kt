/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 * 变异，将一个基因变成另一个基因
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface IMutator<G> {

    /**
     * 基因变异成另一个基因
     */
    fun mutate(gene:G):G
}