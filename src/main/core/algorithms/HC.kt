/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms

import core.AbstractAlgorithm
import core.IProblem
import core.Individual

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class HC<G,X>:AbstractAlgorithm<G,X>() {
    override fun solve(problem: IProblem<X>): Individual<G, X> {
        val parent=searcher.search()
        val result=Individual<G,X>(parent,translator)
        result.quality=problem.evaluate(result.solution)

        val cur=Individual<G,X>(parent,translator)
        while (!terminator.shouldTerminate()){
            cur.gene=mutator.mutate(cur.gene)
            cur.quality=problem.evaluate(cur.solution)

            if (result.quality<=cur.quality){
                result.assign(cur)
            }
        }
        return result
    }
}