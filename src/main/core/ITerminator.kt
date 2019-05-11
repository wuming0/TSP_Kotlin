/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 * 终结器，判断是否结束
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface ITerminator {

    /**
     * 是否已经终止
     */
    fun isStop():Boolean

    /**
     * 是否终止
     */
    fun shouldTerminate():Boolean
}