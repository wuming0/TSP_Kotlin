/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.ea

/**
 * 两个基因进行杂交
 *@作者:Zhichao Wu
 *@时间:2019/4/24 19:34
 */
interface IHybridOperate<G> {

    /**
     * 两个基因杂交后生成一个新的基因
     */
    fun recombine(father: G, mother: G): G
}