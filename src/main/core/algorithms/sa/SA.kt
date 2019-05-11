/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.sa

import core.AbstractAlgorithm
import core.IProblem
import core.Individual
import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class SA<G, X> : AbstractAlgorithm<G, X>() {
    lateinit var temperature: ITemperature

    private val random = Random()

    override fun solve(problem: IProblem<X>): Individual<G, X> {
        var energyDifference: Double
        var time = 1

        val parent = searcher.search()
        val cur = Individual<G, X>(parent, translator)
        cur.quality = problem.evaluate(cur.solution)

        val result = Individual(parent, translator)
        result.quality = cur.quality

        val next = Individual(parent, translator)

        while (!terminator.shouldTerminate()) {
            next.gene = mutator.mutate(next.gene)
            next.quality = problem.evaluate(next.solution)
            energyDifference = next.quality - cur.quality
            if (energyDifference > 0) {
                cur.assign(next)
                if (cur.quality > result.quality) {
                    result.assign(cur)
                }
            } else {
                if (random.nextDouble() < Math.exp(energyDifference / temperature.getTemperature(time))) {
                    cur.assign(next)
                }
            }
            time++
        }
        return result
    }
}