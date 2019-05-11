/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package problems.TSP

import core.algorithms.HC
import core.algorithms.sa.ITemperature
import core.algorithms.sa.SA
import core.algorithms.sa.temperatures.ExponentialSchedule
import core.algorithms.sa.temperatures.LogarithmicSchedule
import core.algorithms.sa.temperatures.PolynomialSchedule
import core.mutators.SimpleSwapIntMutator
import core.searchers.RandomSearcher
import core.terminators.StepTerminator
import core.translators.CopyTranslator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
private fun run(temperatureSchedule:ITemperature){
    val problem=TSPProblem(25)

    val saSolution= SA<IntArray,IntArray>()
    saSolution.searcher= RandomSearcher(problem.citiesCount)
    saSolution.mutator= SimpleSwapIntMutator()
    saSolution.terminator= StepTerminator(100_0000)
    saSolution.translator= CopyTranslator()
    saSolution.temperature= temperatureSchedule

    val result=saSolution.solve(problem)
    println("${-result.quality}=${problem.getTripFoot(result.solution)}")
    println(result)
}

fun main(args: Array<String>) {
    run(LogarithmicSchedule(500.0))

    run(ExponentialSchedule(500))

    run(PolynomialSchedule(500.0))
}