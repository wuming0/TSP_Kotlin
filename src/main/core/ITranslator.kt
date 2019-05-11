/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 * 转换器，将基因翻译成解
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface ITranslator<G,X> {

    /**
     * 将基因翻译成解
     */
    fun geneToSolution(gene:G):X
}