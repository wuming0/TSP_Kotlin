/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core

/**
 * 基因空间搜索器
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
interface ISearcher<G> {

    /**
     * 得到一个基因
     */
    fun search():G
}