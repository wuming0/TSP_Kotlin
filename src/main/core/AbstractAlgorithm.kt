/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

import core.translators.CopyTranslator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
abstract class AbstractAlgorithm<G, X> {

    lateinit var searcher: ISearcher<G> //空间搜索器

    lateinit var mutator:IMutator<G> //变异

    lateinit var terminator:ITerminator //终结器

    var translator:ITranslator<G,X> =CopyTranslator<Any>() as ITranslator<G,X> //转换器

    /**
     * 解算法
     */
    abstract fun solve(problem:IProblem<X>):Individual<G,X>
}