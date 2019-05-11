/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package problems.TSP

import core.algorithms.HC
import core.algorithms.ea.CombineTwoIntArray
import core.algorithms.ea.EA
import core.algorithms.ea.selections.TruncationSelection
import core.mutators.SimpleSwapIntMutator
import core.searchers.RandomSearcher
import core.terminators.StepTerminator
import core.translators.CopyTranslator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/24 20:14
 */

fun main(args: Array<String>) {
    val problem=TSPProblem(25)

    val eaSolution= EA<IntArray,IntArray>(100,70,0.02)
    eaSolution.searcher= RandomSearcher(problem.citiesCount)
    eaSolution.mutator= SimpleSwapIntMutator()
    eaSolution.terminator= StepTerminator(100_0000)
    eaSolution.translator= CopyTranslator()
    eaSolution.selector=TruncationSelection()
    eaSolution.hybridOperate=CombineTwoIntArray()

    val result=eaSolution.solve(problem)
    println("${-result.quality}=${problem.getTripFoot(result.solution)}")
    println(result)
}