/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.sa.temperatures

import core.algorithms.sa.ITemperature

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class ExponentialSchedule constructor(
        private val startTemperature: Int,
        exactValue: Double = 0.05
) : ITemperature {

    private val exact = if (exactValue > 0 && exactValue < 1) {
        1 - exactValue
    } else {
        0.95
    }

    override fun getTemperature(timePoint: Int): Double {
        return Math.pow(exact, timePoint.toDouble() * startTemperature)
    }
}