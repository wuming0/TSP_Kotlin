/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.translators

import core.ITranslator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class CopyTranslator<G>:ITranslator<G,G> {
    override fun geneToSolution(gene: G): G {
        return gene
    }
}