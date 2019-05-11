/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 * 问题描述
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface IProblem<X> {

    /**
     * 评价解的得分，越高解越好
     */
    fun evaluate(solution:X):Double

}