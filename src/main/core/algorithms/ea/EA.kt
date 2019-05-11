/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.ea

import core.AbstractAlgorithm
import core.IProblem
import core.Individual
import java.util.*

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class EA<G,X> constructor(
        val populationSize:Int,
        val matingPoolSize:Int,
        val crossoverRate:Double
):AbstractAlgorithm<G,X>(){
    private val randomer=Random()
    lateinit var selector:ISelection<G,X>
    lateinit var hybridOperate: IHybridOperate<G>

    override fun solve(problem: IProblem<X>): Individual<G, X> {
        val population=Array<Individual<G,X>>(populationSize){
            Individual(this.searcher.search(),translator)
        }

        val matingPool=Array<Individual<G,X>>(matingPoolSize){
            Individual(this.searcher.search(),translator)
        }

        val result=Individual(this.searcher.search(),translator)
        result.quality=problem.evaluate(result.solution)

        while (true){
            for (elem in population){
                elem.quality=problem.evaluate(elem.solution)
                if (elem.quality>result.quality){
                    result.assign(elem)
                }
                if (this.terminator.shouldTerminate()){
                    return result;
                }
            }

            this.selector.select(population,matingPool)

            for (i in 0 until populationSize){
                val gene=if (randomer.nextDouble()<this.crossoverRate){
                    hybridOperate.recombine(matingPool[i%matingPoolSize].gene,matingPool[randomer.nextInt(matingPoolSize)].gene)
                }else{
                    mutator.mutate(matingPool[i%matingPoolSize].gene)
                }
                population[i]=Individual(gene,translator)
            }
        }
    }
}