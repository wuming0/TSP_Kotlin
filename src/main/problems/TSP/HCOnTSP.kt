/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package problems.TSP

import core.algorithms.HC
import core.mutators.SimpleSwapIntMutator
import core.searchers.RandomSearcher
import core.terminators.StepTerminator
import core.translators.CopyTranslator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */

fun main(args: Array<String>) {
    val problem=TSPProblem(25)

    val hcSolution=HC<IntArray,IntArray>()
    hcSolution.searcher=RandomSearcher(problem.citiesCount)
    hcSolution.mutator=SimpleSwapIntMutator()
    hcSolution.terminator=StepTerminator(100_0000)
    hcSolution.translator=CopyTranslator()

    val result=hcSolution.solve(problem)
    println("${-result.quality}=${problem.getTripFoot(result.solution)}")
    println(result)
}