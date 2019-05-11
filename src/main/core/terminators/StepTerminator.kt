/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.terminators

import core.ITerminator

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class StepTerminator constructor(
        maxStep:Int
):ITerminator{
    private var step=maxStep

    override fun isStop(): Boolean {
        return step<=0
    }

    override fun shouldTerminate(): Boolean {
        return (--step)<0
    }
}