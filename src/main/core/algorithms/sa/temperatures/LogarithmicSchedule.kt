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
class LogarithmicSchedule constructor(
        private val startTemperature: Double
) : ITemperature {

    override fun getTemperature(timePoint: Int): Double {
        return if (timePoint < Math.E) {
            startTemperature
        } else {
            startTemperature / Math.log(timePoint.toDouble())
        }
    }
}