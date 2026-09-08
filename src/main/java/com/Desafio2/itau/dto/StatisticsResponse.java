package com.Desafio2.itau.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticsResponse {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public StatisticsResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();

        if (stats.getCount() == 0) {
            this.sum = 0;
            this.avg = 0;
            this.min = 0;
            this.max = 0;
            return;
        }

        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }
}
