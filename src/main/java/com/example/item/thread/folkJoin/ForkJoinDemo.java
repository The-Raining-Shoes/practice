package com.example.item.thread.folkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private final Long startNum;
    private final Long endNum;

    public ForkJoinDemo(Long start, Long end) {
        this.startNum = start;
        this.endNum = end;
    }

    @Override
    protected Long compute() {
        // 当最大最小参数相差小于10万的时候，直接做计算操作
        long tempNum = 10000L;
        if ((endNum - startNum) < tempNum) {
            long sum = 0L;
            for (Long i = startNum; i <= endNum; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (startNum + endNum) / 2;
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(startNum, middle);
            forkJoinDemo1.fork(); //拆分队列，把任务压入线程队列
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo(middle+1, endNum);
            forkJoinDemo2.fork();
            return (forkJoinDemo1.join() + forkJoinDemo2.join());
        }
    }

}
