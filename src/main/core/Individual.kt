/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class Individual<G,X> constructor(
        var gene:G,
        var translator:ITranslator<G,X>,
        var quality:Double
):Comparable<Individual<G,X>?>{

    constructor(gene:G,translator: ITranslator<G, X>):this(gene,translator, Double.NEGATIVE_INFINITY)

    val solution get() = translator.geneToSolution(gene)

    fun assign(copyThis:Individual<G,X>){
        this.gene=copyThis.gene
        this.translator=copyThis.translator
        this.quality=copyThis.quality
    }

    override fun toString(): String {
        val result=StringBuilder()
        result.append("[得分]${this.quality}")

        if (this.gene!=this.solution&& this.gene!=null){
            result.append("[基因]${Utils.toString(this.gene)}")
            result.append("[显型]")
        }else{
            result.append("[解决方案]")
        }
        result.append(Utils.toString(this.solution))
        return result.toString()
    }

    override fun compareTo(other: Individual<G, X>?): Int {
        if (other==this){
            return 0
        }
        if (other==null){
            return -1
        }
        return this.quality.compareTo(other.quality)
    }
}